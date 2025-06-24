package Test_Rail;

import java.util.HashMap;
import java.util.Map;


public class Test_Rail_Actions {
	
	
    public void updateTestRailTestRunStatus(String testrailId, String status, String expected, String actual)
    {
          /*String testrailId = "2236315";
          String status = "failed";
          String expected = "Expected 1";
          String actual = "Actual 2";*/
          Map<String, Object> testdata = new HashMap<String, Object>();
          if(status.equalsIgnoreCase("pass")){
                testdata.put("Status_id", String.valueOf(TestRailUtil.Status.SUCCESS.getValue()));
                testdata.put("comment","Expected :: " +expected    +"\n Actual::"+ actual);
                TestRailUtil.updateTestRailData(testrailId, testdata);
                }
                else{
                   if(!testrailId.isEmpty()){
                         
                         testdata.put("Status_id", String.valueOf(TestRailUtil.Status.FAIL.getValue()));
                         testdata.put("comment","Expected :: " +expected    +"\n Actual::"+ actual);
                         TestRailUtil.updateTestRailData(testrailId, testdata);
                   }
                }        
    }



}
