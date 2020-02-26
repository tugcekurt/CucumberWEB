package managers;

import dataProviders.ConfigFileReader;

public class FileReadManager {

    private static FileReadManager fileReaderManager = new FileReadManager();
    private static ConfigFileReader configFileReader;

    private FileReadManager() {
    }

    public static FileReadManager getInstance( ) {
        return fileReaderManager;
    }

    public ConfigFileReader getConfigReader() {
        return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
    }
}
