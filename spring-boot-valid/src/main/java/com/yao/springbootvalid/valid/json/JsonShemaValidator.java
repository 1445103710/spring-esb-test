package com.yao.springbootvalid.valid.json;


import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

import java.io.IOException;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yaoyao
 * @version 1.0
 * @createDate 2019/03/29 16:07
 * @Description:
 * @see com.yao.springbootvalid.valid.json
 */
@Slf4j
public class JsonShemaValidator {

    private final static JsonSchemaFactory factory = JsonSchemaFactory.byDefault();

    /**
     * validate instance and Schema,here including two functions. as follows:
     * first： the Draft v4 will check the syntax both of schema and instance.
     * second： instance validation.
     *
     * @param mainSchema
     * @param instance
     * @return
     * @throws IOException
     * @throws ProcessingException
     */
    public static ProcessingReport validatorSchema(String mainSchema, String instance) throws IOException, ProcessingException {
        JsonNode mainNode = JsonLoader.fromString(mainSchema);
        JsonNode instanceNode = JsonLoader.fromString(instance);
        JsonSchema schema = factory.getJsonSchema(mainNode);
        ProcessingReport processingReport = schema.validate(instanceNode);

        return processingReport;
    }


    /*
     * 用给定schema校验给定json实例
     *
     */
    public static ProcessingReport validateJson(JsonSchema schema, JsonNode instance) throws ProcessingException{
        return schema.validate(instance);
    }

    /*
     * 解析Json串
     * @param jsonStr
     * @return JsonNode
     */
    public static JsonNode resolveJson(String jsonStr) throws IOException{
        try {
            return JsonLoader.fromString(jsonStr);
        } catch (IOException e) {
            return JsonLoader.fromString("{}");
        }
    }

    public static void main(String[] args){
        String sch = "{\n" +
                "  \"$schema\": \"http://json-schema.org/draft-04/schema#\",\n" +
                "  \"type\": \"object\",\n" +
                "  \"properties\": {\n" +
                "    \"body\": {\n" +
                "      \"type\": \"object\",\n" +
                "      \"properties\": {\n" +
                "        \"username\": {\n" +
                "          \"type\": \"string\"\n" +
                "        },\n" +
                "        \"age\": {\n" +
                "          \"type\": \"string\"\n" +
                "        },\n" +
                "        \"call\": {\n" +
                "          \"type\": \"object\",\n" +
                "          \"properties\": {\n" +
                "            \"english\": {\n" +
                "              \"type\": \"string\"\n" +
                "            },\n" +
                "            \"chinese\": {\n" +
                "              \"type\": \"string\",\n" +
                "              \"minLength\": 0,\n" +
                "              \"maxLength\": 15\n" +
                "            }\n" +
                "          },\n" +
                "          \"required\": [\n" +
                "            \"english\",\n" +
                "            \"chinese\"\n" +
                "          ]\n" +
                "        }\n" +
                "      },\n" +
                "      \"required\": [\n" +
                "        \"call\"\n" +
                "      ]\n" +
                "    }\n" +
                "  },\n" +
                "  \"required\": [\n" +
                "    \"body\"\n" +
                "  ]\n" +
                "}";

        String json = "{\n" +
                "  \"body\": {\n" +
                "    \"username\": \"haha\",\n" +
                "    \"age\": \"12\",\n" +
                "    \"call\": {\n" +
                "      \"english\": \"12:12:12111:122222222222222222222222222222\",\n" +
                "      \"chinese\": \"str12322222222222222222222222222222222222222222222222224\"\n" +
                "    }\n" +
                "  }\n" +
                "}";

        try {
            ProcessingReport processingMessages = validatorSchema(sch, json);
            System.out.println(processingMessages.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ProcessingException e) {
            e.printStackTrace();
        }
    }
}
