/*
 * WSO2 API Manager - Publisher API
 * This specifies a **RESTful API** for WSO2 **API Manager** - Publisher.  Please see [full swagger definition](https://raw.githubusercontent.com/wso2/carbon-apimgt/v6.0.4/components/apimgt/org.wso2.carbon.apimgt.rest.api.publisher/src/main/resources/publisher-api.yaml) of the API which is written using [swagger 2.0](http://swagger.io/) specification. 
 *
 * OpenAPI spec version: 0.10.0
 * Contact: architecture@wso2.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package org.wso2.carbon.apimgt.rest.integration.tests.api;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.wso2.carbon.apimgt.rest.integration.tests.ApiException;
import org.wso2.carbon.apimgt.rest.integration.tests.model.*;
import org.testng.annotations.Test;

import java.util.ArrayList;

/**
 * API tests for APICollectionApi
 */
public class APICollectionApiIT {

    private final APICollectionApi api = new APICollectionApi();
    private static String apiID;

    /**
     * Retrieve/Search APIs
     * <p>
     * This operation provides you a list of available APIs qualifying under a given search condition.  Each retrieved API is represented with a minimal amount of attributes. If you want to get complete details of an API, you need to use **Get details of an API** operation.
     *
     * @throws ApiException if the Api call fails
     */
    @Test(dependsOnMethods = "apisPostTest", enabled = true)
    public void apisGetTest() throws ApiException {
        Integer limit = 10;
        Integer offset = 2;
        String query = null;
        String accept = null;
        String ifNoneMatch = null;
        APIList response = api.apisGet(limit, offset, query, accept, ifNoneMatch);
        Assert.assertEquals(response.getList().get(0).getName(), "API-117", "API name mismatch");
    }

    /**
     * Check given API attibute name is already exist
     * <p>
     * Using this operation, you can check a given API context is already used. You need to provide the context name you want to check.
     *
     * @throws ApiException if the Api call fails
     */
    @Test(dependsOnMethods = "apisPostTest", enabled = true)
    public void apisHeadTest() throws ApiException {
        String query = "name:API-117";
        String accept = null;
        String ifNoneMatch = null;
        api.apisHead(query, accept, ifNoneMatch);

        // TODO: test validations (will thrown API Not Found exception if not available)
    }

    /**
     * Check for error if given API attribute does not exist
     * <p>
     * TODO: Check if this is required (NO IHMO)
     *
     * @throws ApiException
     */
    @Test(dependsOnMethods = "apisHeadTest", expectedExceptions = ApiException.class)
    public void apisHeadFailureTest() throws ApiException {
        String query = "name:DoesNotExist";
        String accept = null;
        String ifNoneMatch = null;
        api.apisHead(query, accept, ifNoneMatch);
    }

    /**
     * Create a new API
     * <p>
     * This operation can be used to create a new API specifying the details of the API in the payload. The new API will be in &#x60;CREATED&#x60; state.  There is a special capability for a user who has &#x60;APIM Admin&#x60; permission such that he can create APIs on behalf of other users. For that he can to specify &#x60;\&quot;provider\&quot; : \&quot;some_other_user\&quot;&#x60; in the payload so that the API&#39;s creator will be shown as &#x60;some_other_user&#x60; in the UI.
     *
     * @throws ApiException if the Api call fails
     */
    @Test(enabled = true)
    public void apisPostTest() throws ApiException {
        API body = new API();
        String contentType = "application/json";
        if (body != null) {
            body.setApiDefinition("{ \t\"paths\": { \t\t\"/order\": { \t\t\t\"post\": { \t\t\t\t\"x-auth-type\": " +
                    "\"Application & Application User\", \t\t\t\t\"x-throttling-tier\": \"Unlimited\", \t\t\t\t\"description\":" +
                    " \"Create a new Order\", \t\t\t\t\"parameters\": [{ \t\t\t\t\t\"schema\": { \t\t\t\t\t\t\"$ref\"" +
                    ": \"#/definitions/Order\" \t\t\t\t\t}, \t\t\t\t\t\"description\": \"Order object that needs to be added\"," +
                    " \t\t\t\t\t\"name\": \"body\", \t\t\t\t\t\"required\": true, \t\t\t\t\t\"in\": \"body\" \t\t\t\t}]," +
                    " \t\t\t\t\"responses\": { \t\t\t\t\t\"201\": { \t\t\t\t\t\t\"headers\": { \t\t\t\t\t\t\t\"Location\"" +
                    ": { \t\t\t\t\t\t\t\t\"description\": \"The URL of the newly created resource.\", \t\t\t\t\t\t\t\t\"type" +
                    "\": \"string\" \t\t\t\t\t\t\t} \t\t\t\t\t\t}, \t\t\t\t\t\t\"schema\": { \t\t\t\t\t\t\t\"$ref\":" +
                    " \"#/definitions/Order\" \t\t\t\t\t\t}, \t\t\t\t\t\t\"description\": \"Created.\" \t\t\t\t\t} " +
                    "\t\t\t\t} \t\t\t} \t\t}, \t\t\"/menu\": { \t\t\t\"get\": { \t\t\t\t\"x-auth-type\": " +
                    "\"Application & Application User\", \t\t\t\t\"x-throttling-tier\": \"Unlimited\", " +
                    "\t\t\t\t\"description\": \"Return a list of available menu items\", \t\t\t\t\"parameters\":" +
                    " [], \t\t\t\t\"responses\": { \t\t\t\t\t\"200\": { \t\t\t\t\t\t\"headers\": {}, \t\t\t\t\t\t\"schema\":" +
                    " { \t\t\t\t\t\t\t\"title\": \"Menu\", \t\t\t\t\t\t\t\"properties\": { \t\t\t\t\t\t\t\t\"list\": " +
                    "{ \t\t\t\t\t\t\t\t\t\"items\": { \t\t\t\t\t\t\t\t\t\t\"$ref\": \"#/definitions/MenuItem\" " +
                    "\t\t\t\t\t\t\t\t\t}, \t\t\t\t\t\t\t\t\t\"type\": \"array\" \t\t\t\t\t\t\t\t} \t\t\t\t\t\t\t}, " +
                    "\t\t\t\t\t\t\t\"type\": \"object\" \t\t\t\t\t\t}, \t\t\t\t\t\t\"description\": \"OK.\" \t\t\t\t\t} " +
                    "\t\t\t\t} \t\t\t} \t\t} \t}, \t\"schemes\": [\"https\"], \t\"produces\": [\"application/json\"]," +
                    " \t\"swagger\": \"2.0\", \t\"definitions\": { \t\t\"MenuItem\": { \t\t\t\"title\": \"Pizza menu Item\", " +
                    "\t\t\t\"properties\": { \t\t\t\t\"price\": { \t\t\t\t\t\"type\": \"string\" \t\t\t\t}, \t\t\t\t\"description\":" +
                    " { \t\t\t\t\t\"type\": \"string\" \t\t\t\t}, \t\t\t\t\"name\": { \t\t\t\t\t\"type\": \"string\" \t\t\t\t}," +
                    " \t\t\t\t\"image\": { \t\t\t\t\t\"type\": \"string\" \t\t\t\t} \t\t\t}, \t\t\t\"required\": [\"name\"] \t\t}," +
                    " \t\t\"Order\": { \t\t\t\"title\": \"Pizza Order\", \t\t\t\"properties\": { \t\t\t\t\"customerName\": " +
                    "{ \t\t\t\t\t\"type\": \"string\" \t\t\t\t}, \t\t\t\t\"delivered\": { \t\t\t\t\t\"type\":" +
                    " \"boolean\" \t\t\t\t}, \t\t\t\t\"address\": { \t\t\t\t\t\"type\": \"string\" \t\t\t\t}," +
                    " \t\t\t\t\"pizzaType\": { \t\t\t\t\t\"type\": \"string\" \t\t\t\t}, \t\t\t\t\"creditCardNumber\":" +
                    " { \t\t\t\t\t\"type\": \"string\" \t\t\t\t}, \t\t\t\t\"quantity\": { \t\t\t\t\t\"type\": \"number\" \t\t\t\t}, " +
                    "\t\t\t\t\"orderId\": { \t\t\t\t\t\"type\": \"integer\" \t\t\t\t} \t\t\t}, \t\t\t\"required\": " +
                    "[\"orderId\"] \t\t } \t}, \t\"consumes\": [\"application/json\"], \t\"info\": { \t\t\"title\": " +
                    "\"PizzaShackAPI\", \t\t\"description\":" +
                    " \"This document describe a RESTFul API for Pizza Shack online pizza delivery store.\\n\", \t\t\"license\": " +
                    "{ \t\t\t\"name\": \"Apache 2.0\", \t\t\t\"url\": \"http://www.apache.org/licenses/LICENSE-2.0.html\" \t\t}, " +
                    "\t\t\"contact\": { \t\t\t\"email\": \"architecture@pizzashack.com\", \t\t\t\"name\": \"John Doe\", " +
                    "\t\t\t\"url\": \"http://www.pizzashack.com\" \t\t}, \t\t\"version\": \"1.0.0\" \t} }");
        }
        body.setName("API-117");
        body.setContext("API-117");
        body.setVersion("111");
        body.setProvider("admin");
        body.setLifeCycleStatus("CREATED");
        body.setTransport(new ArrayList<String>() {{
            add("http");
        }});
        body.setCacheTimeout(100);
        body.setPolicies(new ArrayList<String>() {{
            add("Unlimited");
        }});
        body.setVisibility(API.VisibilityEnum.PUBLIC);
        body.setTags(new ArrayList<String>());
        body.setMaxTps(new APIMaxTps());
        body.setVisibleRoles(new ArrayList<String>());
        body.setVisibleTenants(new ArrayList<String>());
        body.setEndpointSecurity(new APIEndpointSecurity());
        body.setSequences(new ArrayList<Sequence>());
        body.setBusinessInformation(new APIBusinessInformation());
        body.setCorsConfiguration(new APICorsConfiguration());
        API response = api.apisPost(body, contentType);
        this.apiID = response.getId();
        Assert.assertTrue(true);
    }

    @AfterClass
    public void afterClass() throws ApiException {
        APIIndividualApi apiClient = new APIIndividualApi();

        APIList response = api.apisGet(1, 1, null, null, null);

        String apiId = response.getList().get(0).getId();
        String ifMatch = null;
        String ifUnmodifiedSince = null;
        apiClient.apisApiIdDelete(apiId, ifMatch, ifUnmodifiedSince);
    }

}
