package com.dharma.patterns.gof.behavioral.command;

// 命令接受者
interface FileSystemReceiver {
    void openFile();

    void writeFile();

    void closeFile();
}

class UnixFileSystemReceiver implements FileSystemReceiver {

    @Override
    public void openFile() {
        System.out.println("Opening file in unix OS");
    }

    @Override
    public void writeFile() {
        System.out.println("Writing file in unix OS");
    }

    @Override
    public void closeFile() {
        System.out.println("Closing file in unix OS");
    }

}

class WindowsFileSystemReceiver implements FileSystemReceiver {

    @Override
    public void openFile() {
        System.out.println("Opening file in Windows OS");

    }

    @Override
    public void writeFile() {
        System.out.println("Writing file in Windows OS");
    }

    @Override
    public void closeFile() {
        System.out.println("Closing file in Windows OS");
    }

}

//命令
interface FileCommand {

    void execute();
}

class OpenFileCommand implements FileCommand {

    private FileSystemReceiver fileSystem;

    OpenFileCommand(FileSystemReceiver fs) {
        this.fileSystem = fs;
    }

    @Override
    public void execute() {
        this.fileSystem.openFile();
    }

}

class CloseFileCommand implements FileCommand {

    private FileSystemReceiver fileSystem;

    CloseFileCommand(FileSystemReceiver fs) {
        this.fileSystem = fs;
    }

    @Override
    public void execute() {
        this.fileSystem.closeFile();
    }

}

class WriteFileCommand implements FileCommand {

    private FileSystemReceiver fileSystem;

    WriteFileCommand(FileSystemReceiver fs) {
        this.fileSystem = fs;
    }

    @Override
    public void execute() {
        this.fileSystem.writeFile();
    }

}

//命令调用者
class FileInvoker {

    private FileCommand command;

    FileInvoker(FileCommand c) {
        this.command = c;
    }

    public void execute() {
        this.command.execute();
    }
}

class FileSystemReceiverUtil {

    public static FileSystemReceiver getUnderlyingFileSystem() {
        String osName = System.getProperty("os.name");
        System.out.println("Underlying OS is:" + osName);
        if (osName.contains("Windows")) {
            return new WindowsFileSystemReceiver();
        } else {
            return new UnixFileSystemReceiver();
        }
    }

}


public class FileSystemClient {

    public static void main(String[] args) {
        //定义 接受者
        FileSystemReceiver fs = FileSystemReceiverUtil.getUnderlyingFileSystem();

        //定义 调用者 和 命令
        OpenFileCommand openFileCommand = new OpenFileCommand(fs);
        FileInvoker file = new FileInvoker(openFileCommand);
        file.execute();

        //定义 调用者 和 写命令
        WriteFileCommand writeFileCommand = new WriteFileCommand(fs);
        file = new FileInvoker(writeFileCommand);
        file.execute();

        //定义 调用者 和 关闭命令
        CloseFileCommand closeFileCommand = new CloseFileCommand(fs);
        file = new FileInvoker(closeFileCommand);
        file.execute();
    }

}