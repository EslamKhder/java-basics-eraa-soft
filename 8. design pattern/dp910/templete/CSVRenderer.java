package main.dp910.templete;

public class CSVRenderer extends DataRenderer {

    @Override
    public Object readData() {
        return "CSV Data";
    }

    @Override
    public Object processData(Object data) {
        return "Processed " + data;
    }
}