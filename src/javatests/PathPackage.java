package javatests;

import java.io.File;
import java.io.IOException;

public class PathPackage {
    // универсальный разделитель директорий
    private final String separator = File.separator;
    private final String packageName;
    private final String fileName;
    //принимаем информацию о пакете в котором лежит класс (ожидаемая команда MyClass.class.getPackageName())
    public PathPackage(String packageName, String fileName){
        this.packageName = packageName;
        this.fileName = fileName;
    }
    //Преобразуем полученные данные в путь к файлу относительно проекта (path принимает название файла с расширением)
    public File getFile()  {
        String path = "src" + separator + packageName.replace(".", separator) + separator+fileName;
        File inputFile = new File(path);
        try{
            if (!inputFile.exists()){
                inputFile.createNewFile();
            }
        }catch (IOException e){
            System.out.println("Возникла ошибка при работе с внешним файлом");
        }

        return inputFile;
    }
}
