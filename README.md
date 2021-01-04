# babe
Bootstrap Applied on BackEnd (Babe) >>> Open source tool to generate Rest CRUD Spring boot project 


Known issues:

While defining the fieldDetails.fieldType , currently int,string are supported.

As there is no file server as of now, you have to download the sample project structure in resources directory and change Base path[PortalConstants.PROJECT_FILE_STRUCTURE] accordingly.


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
	"username":"root",
	"password":"root"
	}
}

