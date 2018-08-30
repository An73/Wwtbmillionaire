package com.dkotenko.wwtbmillionaire.wwtbmillionaire;
public  class BdQuestions{
    private String quastions[] = {"Платформа Андроид основывается на операционной системе",
            "Как называется Java виртуальная машина платформы Андроид?",
            "Пустой процесс не должен иметь",
            "Какой первый телефон был выпущен на Android OS?",
            "Когда Google купил Android?",
            "R файл генерируется",
            "Какой конфигурационный файл содержит разрешение на использование GPS?",
            "Как называется папка содержащая файл R.java?",
            "Какой Android пакет используется для работы с датой/временем?",
            "Какие из следующих виджетов помогают встроить изображения в активность?",
            "Для создания пользовательского интерфейса Android вы должны использовать",
            "Какой из следующих файлов описывает, из чего состоит приложение?",
            "База данных автоматически предоставляется Android",
            "Для использования C/C++ требуется",
            "Что из следующего является базовым классом Activity и Service?"};
    private int answer[] = {0, 1, 0, 3, 1, 2, 1, 3, 2, 2, 1, 2, 0, 3, 3};
    private String variants[][] = {{"Linux", "Mac", "Unix", "Windows"},
            {"NET Framework", "Dalvik", "Juke Virtual Machine", "Parrot Virtual Machine"},
            {"Активных компонентов приложения", "Активных прцессов", "Активных сервисов", "Любых ресурсов"},
            {"Google gPhone", "Motorola Droid", "HTC Hero", "T-Mobile G1"},
            {"2007", "2005", "2008", "2010"},
            {"В ручном режиме", "Эмулируется", "Автоматически", "Нет такого файла"},
            {"Layout file", "Manifest file", "Source file", "Property file"},
            {"src", "res", "bin", "gen"},
            {"view", "test", "util", "text"},
            {"ImageView", "ImageButton", "ImageView и ImageButton", "Ничего из перечисленного"},
            {"Eclipse", "Java и XML", "Java и SQL", "Java и PL/SQL"},
            {"Strings XML", "R file", "AndroidManifest", "Layout file"},
            {"SQLite", "Apache", "Oracle", "MySQL"},
            {"SDK", "JDK", "MDK", "NDK"},
            {"Component", "Object", "Application", "Context"}};

    String getQuestion(int id){
        return quastions[id];
    }

    int getAnswer(int id){
        return answer[id];
    }

    String[] getVariants(int id) {
        return variants[id];
    }

}
