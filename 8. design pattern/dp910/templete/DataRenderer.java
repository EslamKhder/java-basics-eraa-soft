package main.dp910.templete;

public abstract class DataRenderer {

    public void render() {
        Object data = readData();
        Object processed = processData(data);
        System.out.println("Rendering: " + processed);
    }

    protected abstract Object readData();
    protected abstract Object processData(Object data);
}
