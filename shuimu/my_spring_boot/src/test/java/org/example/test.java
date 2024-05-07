package org.example;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import org.dom4j.*;
import org.dom4j.io.DocumentSource;
import org.dom4j.io.SAXReader;
import org.example.pojo.ExcelVo;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.util.CollectionUtils;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {
    /*@Test
    public void getXMlInfo() {

        TransformerFactory tff = TransformerFactory.newInstance();
        //创建 Transformer 对象
        Transformer tf = null;
        try {
            tf = tff.newTransformer();
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        }
        //设置生成的 XML 文件自动换行
        tf.setOutputProperty(OutputKeys.INDENT, "yes");
        tf.setOutputProperty(OutputKeys.ENCODING, "GBK");




        //解析Excel，生成校验规则
        File excelFile = new File("/Users/jie/Documents/convert_xml/产品与公共数据关联关系.xlsx");

        HashMap<String, String> excleMap = new HashMap<>();




        EasyExcel.read(excelFile, ExcelVo.class, new AnalysisEventListener <ExcelVo>() {
            @Override
            public void invoke(ExcelVo excelVo, AnalysisContext analysisContext) {
                excleMap.put(excelVo.getKeyCode(),excelVo.getAutoTypeCode());
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {

            }
        }).sheet().doRead();

      *//*  List<MaterialData> materialList = Arrays.asList(EasyExcel.read(file.getInputStream()).sheet(0).head(DemoData.class).registerReadListener(new DemoDataListener()).doReadSync().toArray(new DemoData[0]));
            if (materialList.isEmpty()) {
                throw new BadRequestException("物料信息读取失败");
            }*//*





        //1、创建读取xml文件的类
        SAXReader saxReader = new SAXReader();
        //2、给定需要读取的文件xml

        File file = new File("/Users/jie/Documents/convert_xml/0312/honor.xml");

        if (!file.exists()) {
            //  System.exit(0);结束程序
            System.out.println("文件不存在");
            return;//结束方法
        }
        try {
            //3、read方法的返回值表示的意思是将问价中所有的内容存到一个DOcument对象中
            Document doc = saxReader.read(file);
            //4、获得所有的元素
            Element rootElement = doc.getRootElement();
            // System.out.println(rootElement.asXML());
            //5、获得跟节点下的所有子节点
            //获得根节点下所有的emp子节点
//             List elements = rootElement.elements("emp");
            Element element = rootElement.element("METADATA");
            Element elementRowDate = element.element("ROWDATA");
            List <Element> elementList = elementRowDate.elements("ROW");

            if (CollectionUtils.isEmpty(elementList)){
                System.out.println("未到数据");
            }




            for (Element rowElement : elementList) {

                List content = rowElement.content();
                Attribute attribute = rowElement.attribute("FILE_CODE");
                String name = attribute.getName();
                String value = attribute.getValue();
                for (Map.Entry<String, String> excleMapEntry : excleMap.entrySet()) {
                    String code = excleMapEntry.getKey();
                    if (value.equals(code)){
                        Attribute fileSecondkind2 = rowElement.attribute("FILE_SECONDKIND2");
                        if (StringUtils.isBlank(fileSecondkind2.getValue())){
                            System.out.println("需要修改的FILE_CODE:"+value+",前值："+fileSecondkind2.getValue()+",需要修改后的值:"+excleMapEntry.getValue());
                        }
                        if (!fileSecondkind2.getValue().equals(excleMapEntry.getValue())){
                            System.out.println("需要修改的FILE_CODE:"+value+",前值："+fileSecondkind2.getValue()+",需要修改后的值:"+excleMapEntry.getValue());
                        }
                        fileSecondkind2.setValue(excleMapEntry.getValue());
                    }
                }
            }

            //使用 Transformer 的 transform 方法把Dom树转换成  XML 文件
            tf.transform(new DocumentSource(doc), new StreamResult(new File("/Users/jie/Documents/convert_xml/0312/honor_update_03_12.xml")));


        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }

    }*/

}

