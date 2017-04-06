import org.w3c.dom.*;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collection;

public class Folders {
    public static Collection<String> folderNames(String xml, char startingLetter) throws Exception {
        String sl = new String(new char[] {startingLetter});

        DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
        Document d = f.newDocumentBuilder().parse(new ByteArrayInputStream(xml.getBytes("utf-8")));

        NodeList folders = d.getElementsByTagName("folder");

        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < folders.getLength(); i++) {
            Node folder = folders.item(i);
            NamedNodeMap attrs = folder.getAttributes();
            String folderName = attrs.getNamedItem("name").getNodeValue();
            if (folderName.startsWith(sl)) {
                result.add(folderName);
            }

        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        String xml =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<folder name=\"c\">" +
                        "<folder name=\"program files\">" +
                        "<folder name=\"uninstall information\" />" +
                        "</folder>" +
                        "<folder name=\"users\" />" +
                        "</folder>";

        Collection<String> names = folderNames(xml, 'u');
        for(String name: names)
            System.out.println(name);
    }
}