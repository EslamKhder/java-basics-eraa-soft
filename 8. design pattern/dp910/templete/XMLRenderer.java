package main.dp910.templete;

public class XMLRenderer extends DataRenderer {


    @Override
    public Object readData() {
        return "XML Data";
    }
    @Override
    public Object processData(Object data) {
        return "Processed " + data;
    }
}