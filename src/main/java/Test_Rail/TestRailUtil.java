package Test_Rail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;



 
public class TestRailUtil {
	//private static Logger logger = Logger.getLogger(new Exception().getStackTrace()[0].getClassName());
   
    
    public enum Status {
        SUCCESS(1), FAIL(5);
        private final int value;
 
        private Status(int value) {
            this.value = value;
        }
 
        public int getValue() {
            return value;
        }
    }
 
    public static String updateTestRail(String testRailId, TestRailUtil.Status status) {
        String url = "https://levistrauss.testrail.io";
        String response = updateTestRail(url, testRailId, status);
        return response;
       
    }
    public static String updateTestRailData(String testRailId,Map<String,Object> data) {
        String url = "https://levistrauss.testrail.io";
        String response = updateTestRailData(url, testRailId, data);
        return response;
       
    }
    public static String updateTestRail(String testRailUrl, String testRailId, TestRailUtil.Status status) {
     
        JSONObject resObj = null;
        APIClient client = new APIClient(testRailUrl);
    
        client.setUser("akhanzode@levi.com");
        client.setPassword("Silver@1438");
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("status_id", status.getValue());
        try {
            resObj = (JSONObject) client.sendPost("add_result/" + testRailId, data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return resObj.toJSONString();
    }
   
    public static String updateTestRailData(String testRailUrl, String testRailId,Map<String,Object> test) {
       
        JSONObject resObj = null;
        APIClient client = new APIClient(testRailUrl);
        client.setUser("akhanzode@levi.com");
        client.setPassword("Silver@1438");
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("status_id", test.get("Status_id"));
        data.put("comment",test.get("comment"));
        try {
            resObj = (JSONObject) client.sendPost("add_result/" + testRailId, data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return resObj.toJSONString();
    }
    
//Get the project ID from the below method
    public static String getProjects(String prjtName){
    	String prjtId=null;
    	String url = "https://levistrauss.testrail.io";
    	Object resObj = null;
    	JSONArray js=null;
    	JSONObject ja=null;
        APIClient client = new APIClient(url);
        client.setUser("akhanzode@levi.com");
        client.setPassword("Silver@1438");
        try {
            resObj = client.sendGet("get_projects");
            js=(JSONArray) resObj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        for(int i=0;i<js.size();i++){
        	ja=(JSONObject) js.get(i);
        	if(ja.get("name").toString().equals(prjtName)){
        		prjtId=ja.get("id").toString();
        	}
        }
        
        return prjtId;
    }
 
    
    
    //Get the run ID from the below method
    public static String getRuns(String prjtId,String runName){
    	String runId=null;
    	String url = "https://levistrauss.testrail.io";
    	Object resObj = null;
    	JSONArray js=null;
    	JSONObject ja=null;
        APIClient client = new APIClient(url);
        client.setUser("akhanzode@levi.com");
        client.setPassword("Silver@1438");
        try {
            resObj = client.sendGet("get_runs/"+prjtId);
            js=(JSONArray) resObj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(int i=0;i<js.size();i++){
        	ja=(JSONObject) js.get(i);
        	if(ja.get("name").toString().equals(runName)){
        		runId=ja.get("id").toString();
        	}
        }        
        
        return runId;
    }
    
  //to get sub run ID  
    public static String getSubRuns(String runId,String subRunName){
    	String sub_run_Id=null;
    	String url = "https://levistrauss.testrail.io";
    	Object resObj = null;
    	JSONArray js=null;
    	JSONObject ja=null;
        APIClient client = new APIClient(url);
        client.setUser("akhanzode@levi.com");
        client.setPassword("Silver@1438");
        try {
            resObj = client.sendGet("get_run/"+runId);
            js=(JSONArray) resObj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(int i=0;i<js.size();i++){
        	ja=(JSONObject) js.get(i);
        	if(ja.get("name").toString().equals(subRunName)){
        		sub_run_Id=ja.get("id").toString();
        	}
        }        
        
        return sub_run_Id;
    }
    
 
    public static String getResults(String sub_run_Id,String test_case_id){
    	String result=null;
    	String url = "https://levistrauss.testrail.io";
    	Object resObj = null;
    	JSONArray js=null;
    	JSONObject ja=null;
        APIClient client = new APIClient(url);
        client.setUser("akhanzode@levi.com");
        client.setPassword("Silver@1438");
        try {
            resObj = client.sendGet("get_results_for_run/"+sub_run_Id);
            js=(JSONArray) resObj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(int i=0;i<js.size();i++){
        	ja=(JSONObject) js.get(i);
        	
        	if(ja.get("test_id").toString().equals(test_case_id)){
        		result=ja.get("id").toString();//can't able to identify which attribute to fetch for result
        	}
        }        
        return result;
    }
	
	  
    
    @SuppressWarnings("unused")
	public static String getTestResults(String case_id){
    	String status=null;
    	String sub_run_Id=null;
    	String url = "https://levistrauss.testrail.io";
    	Object resObj = null;
    	JSONArray js=null;
    	JSONObject ja=null;
        APIClient client = new APIClient(url);
        client.setUser("akhanzode@levi.com");
        client.setPassword("Silver@1438");
        try {
            resObj = client.sendGet("");
            js=(JSONArray) resObj;
        } catch (Exception e) {
            e.printStackTrace();
        }
		/*
		 * for(int i=0;i<js.size();i++){ ja=(JSONObject) js.get(i);
		 * 
		 * status=ja.get("label").toString();
		 * }
		 */
                
        return status;
    }
    
    
    
    
    
    /*
    public static void updateRun(){
    	String url = "https://levistrauss.testrail.io";
    	Object resObj = null;
    	List cid=new ArrayList();
    	cid.add(1272);
    	cid.add(1273);
        APIClient client = new APIClient(url);
        client.setUser("");
        client.setPassword("");
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("include_all", false);
        data.put("case_ids", cid);
        try {
            resObj = client.sendPost("update_run/109",data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    */
    //add new run ID
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static String addRun(String runName,String prjtId, Map<String, Integer> testRailResult){
    	String runId=null;
    	String url = "https://levistrauss.testrail.io";
    	JSONObject js=null;
    	Object resObj = null;
    	List cid=new ArrayList();
    	for (Map.Entry<String, Integer> a: testRailResult.entrySet())
    	{
    		cid.add(a.getKey());
    	}
    	
        APIClient client = new APIClient(url);
        client.setUser("akhanzode@levi.com");
        client.setPassword("Silver@1438");
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("name",runName);
        data.put("include_all", false);
        data.put("case_ids", cid);
        try {
            resObj = client.sendPost("add_run/"+prjtId,data);
            js=(JSONObject) resObj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        runId=js.get("id").toString();
        return runId;
    }
    
    @SuppressWarnings("unused")
	public static ArrayList<String> getTestCases(String projId,String suiteId,String password, String username){
    	String url = "https://levistrauss.testrail.io";
    	JSONArray resObj = null;
    	JSONArray js=null;
    	JSONObject ja=null;
 
        APIClient client = new APIClient(url);
        client.setUser(username);
        client.setPassword(password);
        try {
            resObj = (JSONArray) client.sendGet("get_cases/"+projId+"&suite_id="+suiteId);
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayList<String> caseIds = new ArrayList<String>();
        for (int i = 0; i < resObj.size(); i++) {
            JSONObject jsonobject = (JSONObject) resObj.get(i);
            String caseId = jsonobject.get("id").toString();
            
            caseIds.add(caseId);
        }
       
       return caseIds;
    }
    
    
    @SuppressWarnings("unused")
	public static String addRunToPlan(String planID, String suiteID){
    	String runId=null;
    	String url = "https://levistrauss.testrail.io";
    	JSONObject js=null;
    	Object resObj = null;
    	
    	//String testRunName;
    	//String testRunDescription;
    	//String assignedto_id;
    	//List caseid = new ArrayList<>();
    	List<Object> config_ids = new ArrayList<Object>();
//    	for (Map.Entry<String, Integer> a: testRailResult.entrySet())
//    	{
//    		caseid.add(a.getKey());
//    	}
    	
    	APIClient client = new APIClient(url);
    	 client.setUser("akhanzode@levi.com");
         client.setPassword("Silver@1438");
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("suite_id",suiteID);
        
        data.put("assignedto_id",1);
        data.put("include_all", false);
        data.put("config_ids",config_ids);
        
//        JSONArray childdata = new JSONArray();
//        childdata.put("include_all",false);
//        ((Map) childdata).put("case_ids",caseid);
//        ((Map) childdata).put("config_ids",config_ids);
        //data.put("runs",childdata);
        try {
            resObj = client.sendPost("add_plan_entry/"+planID,data);
            js=(JSONObject) resObj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return runId;
    	
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	public static void updateAutomationResults(Map<String, Integer> testRailResult, Map<String, String> testComments, String runID){
    	String url = "https://levistrauss.testrail.io";
    	Object resObj = null;
    	
    	JSONArray results = new JSONArray();
    	
    	for (Map.Entry<String, Integer> a: testRailResult.entrySet())
    	{
    		JSONObject js1 = new JSONObject();
    		js1.put("case_id",a.getKey().toString());
        	js1.put("status_id",a.getValue().toString());
        	js1.put("comment",testComments.get(a.getKey().toString()));
        	results.add(js1);
    	}
    	
        APIClient client = new APIClient(url);
        client.setUser("akhanzode@levi.com");
        client.setPassword("Silver@1438");
        
        Map data = new HashMap();
        data.put("results", results);
        
        try {
            resObj = client.sendPost("add_results_for_cases/"+runID,data);
        } catch (Exception e) {
            
        }
        
        
    }
    
    public static String getRunName(){
    	String runName = null;
    	try{
    		//runName=BaseSetUp.runName.trim();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
		return runName;
    	
    }
    
    @SuppressWarnings("unused")
	public static String getTestCase(String tc,String password, String username){
    	String url = "https://levistrauss.testrail.io";
    	Object resObj = null;
    	JSONArray js=null;
    	JSONObject ja=null;
 
        APIClient client = new APIClient(url);
        client.setUser(username);
        client.setPassword(password);
        try {
            resObj = client.sendGet("get_case/"+tc);
           ja=(JSONObject) resObj;
        } catch (Exception e) {
            
        }
        
       //String jss= js.toString();
       String suiteID = ja.get("suite_id").toString();
       return suiteID;
    }
    
    public static String createRun(String suiteId,ArrayList<String> caseIds,String prjtId){
    	String runId=null;
    	String url = "https://levistrauss.testrail.io";
    	JSONObject js=null;
    	Object resObj = null;
    	
        APIClient client = new APIClient(url);
        client.setUser("anath2@levi.com");
        client.setPassword("Happy@2019");
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("name","Prod test run");
        data.put("suite_id",suiteId);
        data.put("assignedto_id", 1);
        data.put("include_all", false);
        data.put("refs", "");
        data.put("case_ids", caseIds);
        try {
            resObj = client.sendPost("add_run/"+prjtId,data);
            js=(JSONObject) resObj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        runId=js.get("id").toString();
        return runId;
    }
    

    @SuppressWarnings("unused")
	public static String getSuiteDetails(String suiteID,String password, String username){
    	String url = "https://levistrauss.testrail.io";
    	Object resObj = null;
    	JSONArray js=null;
    	JSONObject ja=null;
        APIClient client = new APIClient(url);
        client.setUser(username);
        client.setPassword(password);
        try {
            resObj = client.sendGet("get_suite/"+suiteID);
           ja=(JSONObject) resObj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
       //String jss= js.toString();
       String projectID = ja.get("project_id").toString();
       return projectID;
    }
    
    public static String getRuns(String prjtId,String runName, String password, String username){
    	String runId=null;
    	String url = "https://levistrauss.testrail.io";
    	Object resObj = null;
    	JSONArray js=null;
    	JSONObject ja=null;
        APIClient client = new APIClient(url);
        client.setUser(username);
        client.setPassword(password);
        try {
            resObj = client.sendGet("get_runs/"+prjtId);
            js=(JSONArray) resObj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(int i=0;i<js.size();i++){
        	ja=(JSONObject) js.get(i);
        	if(ja.get("name").toString().equals(runName)){
        		runId=ja.get("id").toString();
        	}
        }        
        return runId;
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	public static void updateAutomationResults(Map<String, Integer> testRailResult, Map<String, String> testComments, String runID,String password, String username){
    	String url = "https://levistrauss.testrail.io";
    	Object resObj = null;
    	String caseId = null;
    	JSONArray results = new JSONArray();
    	
    	
    	
    	for (Map.Entry<String, Integer> a: testRailResult.entrySet())
    	{
    		List brand = new ArrayList();
    		/*
    		if(BaseSetUp.testBrand.equalsIgnoreCase("levi")){
    			
    			brand.add(new Integer(1));
    		}
    		else{
    			brand.add(new Integer(2));
    		}
    		*/
    		
    		brand.add(new Integer(1));
    	
    		
    		JSONObject js1 = new JSONObject();
    		caseId = a.getKey().toString();
    		js1.put("case_id",a.getKey().toString());
        	js1.put("status_id",a.getValue().toString());
        	js1.put("custom_brand_result",brand);
        	js1.put("comment",testComments.get(a.getKey().toString()));
        	results.add(js1);
    	}
    	
        APIClient client = new APIClient(url);
        client.setUser(username);
        client.setPassword(password);
        
        Map data = new HashMap();
        data.put("results", results);
        
        try {
            resObj = client.sendPost("add_results_for_cases/"+runID,data);
        } catch (Exception e) {
           
        }
        
        
    }
}