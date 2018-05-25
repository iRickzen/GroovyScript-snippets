def myTestCase = context.testCase
propertiesStep = myTestCase.getTestStepByName("Properties") 

fPath = "C:/.../MOCK_DATA.csv"
separator = ","
int row = 3 // Row to read. Starts at 1 -  0 = header

ArrayList data=new ArrayList();

//load data file statically
new File(fPath).splitEachLine(separator){
   data.add(it);
}

//delete all properties
for( prop in propertiesStep.propertyNames )
{
//    log.info( prop + " = " + propertiesStep.properties[prop].value )
propertiesStep.removeProperty(prop)
}


//store content as properties
 for(int i=0; i<data[row].size(); i++){
 	 
     propertiesStep.setPropertyValue(data[0][i], data[row][i]);
}
