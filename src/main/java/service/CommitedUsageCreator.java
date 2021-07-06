package service;

import model.CommitedUsage;

public class CommitedUsageCreator {

    public static final String COMMITED_USAGE = "testdata.commited.usage";

    public static CommitedUsage commitedUsageFromProperty(){
        return new CommitedUsage(TestDataReader.getTestData(COMMITED_USAGE));
    }


}
