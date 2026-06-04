package main.dp910.templete;


public class main {
    public static void main(String[] args) {

        DataRenderer renderer = new XMLRenderer();
        renderer.render();

        renderer = new CSVRenderer();
        renderer.render();

        renderer = new PowRender();
        renderer.render();

    }

}
