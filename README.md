# babe
Bootstrap Applied on BackEnd (Babe) >>> Open source tool to generate Rest CRUD Spring boot project 


Known issues:
While defining the fieldDetails.fieldType , currently int,string are supported

How to test:

Import the files in IDE..
Run TestFrameWork class inside DemoApplication class

Try with below sample file. 

sample JSON which generate spring boot project will be like below.,
```json
{
	"projectName": "babe",
    "appName": "pilot",
	"isSpringBoot": "yes",
	"backEndDB": "mysql",
	"tableName": "customer",
	"tableSchemaNeeded": true,
	"isJpa": true,
	"build": "maven", 
	"fieldDetails": [{
			"fieldName": "id",
			"fieldType": "int",
			"isCustomType": false,
			"isIdentity": true
		},
		{
			"fieldName": "firstName",
			"fieldType": "String",
			"isCustomType": false,
			"isIdentity": false
		},
		{
			"fieldName": "lastName",
			"fieldType": "String",
			"isCustomType": false,
			"isIdentity": false
		},
		{
			"fieldName": "dob",
			"fieldType": "LocalDate",
			"isCustomType": true,
			"isIdentity": false
		}
	],
	"applicationProperties":{
	"port":"8908",
	"contextPath":"management",
	"dataSourceUrl":"jdbc:mysql://localhost:9999",
	"dataBaseName":"base",
	"dataSourceUserName":"root",
	"getDataSourcePassword":"root"
	}
}

