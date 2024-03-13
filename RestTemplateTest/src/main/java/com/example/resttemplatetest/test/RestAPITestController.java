package com.example.resttemplatetest.test;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
@Log4j2
public class RestAPITestController {

    private final RestAPITestService restAPITestService;

    public static class jsonData {
    String str = "{\n" +
            "    \"minorClassification\": [\n" +
            "        {\n" +
            "            \"subject\": \"1154\",\n" +
            "            \"large\": \"115401\",\n" +
            "            \"medium\": \"11540101\",\n" +
            "            \"small\": \"1154010101\",\n" +
            "            \"topic\": \"115401010101\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"subject\": \"1154\",\n" +
            "            \"large\": \"115401\",\n" +
            "            \"medium\": \"11540102\",\n" +
            "            \"small\": \"1154010102\",\n" +
            "            \"topic\": \"115401010201\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"subject\": \"1154\",\n" +
            "            \"large\": \"115401\",\n" +
            "            \"medium\": \"11540103\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"subject\": \"1154\",\n" +
            "            \"large\": \"115401\",\n" +
            "            \"medium\": \"11540104\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"levelCnt\": [\n" +
            "        5,\n" +
            "        5,\n" +
            "        5,\n" +
            "        5,\n" +
            "        5\n" +
            "    ],\n" +
            "    \"questionForm\": \"multiple,subjective\",\n" +
            "    \"activityCategoryList\": [395, 397]\n" +
            "}";

    JSONParser jsonParser = new JSONParser();

    JSONObject ob = (JSONObject) jsonParser.parse(str);

        public jsonData() throws ParseException {
            System.out.println(ob.get("questionForm"));
        }

    }


    @RequestMapping("/")
    public String getTestPage(){
        return "test";
    }

    @PostMapping("/postResponse")
    @ResponseBody
    public ResponseEntity<RestAPITestDTO> postPage (){

        return restAPITestService.postResponse();
    }
}
