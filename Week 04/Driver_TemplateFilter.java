public class Driver_TemplateFilter {
    public static void main(String[] args) {
        String template = "Dear {name}, order {id} ships {date}.";

        String[] names = {"name", "id"};
        String[] values = {"Krina", "A16"};

        String result = TemplateFiller.fill(template, names, values);

        System.out.println(result);
    }
}