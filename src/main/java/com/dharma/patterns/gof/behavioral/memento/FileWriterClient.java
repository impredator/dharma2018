package com.dharma.patterns.gof.behavioral.memento;

//发起人，内部维护备忘录对象
class FileWriterUtil {

    private String fileName;
    private StringBuilder content;

    FileWriterUtil(String file){
        this.fileName=file;
        this.content=new StringBuilder();
    }

    @Override
    public String toString(){
        return this.content.toString();
    }

    public void write(String str){
        content.append(str);
    }

    public Memento save(){
        return new Memento(this.fileName,this.content);
    }

    public void undoToLastSave(Object obj){
        Memento memento = (Memento) obj;
        this.fileName= memento.fileName;
        this.content=memento.content;
    }


    private class Memento{
        private String fileName;
        private StringBuilder content;

        Memento(String file, StringBuilder content){
            this.fileName=file;
            this.content=new StringBuilder(content);
        }
    }
}

//守护人
class FileWriterCaretaker {

    private Object obj;

    public void save(FileWriterUtil fileWriter){
        this.obj=fileWriter.save();
    }

    public void undo(FileWriterUtil fileWriter){
        fileWriter.undoToLastSave(obj);
    }
}

public class FileWriterClient {

    public static void main(String[] args) {

        FileWriterCaretaker caretaker = new FileWriterCaretaker();

        FileWriterUtil fileWriter = new FileWriterUtil("data.txt");
        fileWriter.write("First Set of Data\n");
        System.out.println(fileWriter+"\n\n");

        // 保存
        caretaker.save(fileWriter);

        fileWriter.write("Second Set of Data\n");
        //checking file contents
        System.out.println(fileWriter+"\n\n");

        //撤销操作
        caretaker.undo(fileWriter);
        //撤销后的内容
        System.out.println(fileWriter+"\n\n");

    }

}
