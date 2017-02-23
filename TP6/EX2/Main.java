

class Main {

    public static void main(String[] args){
	try {
	Contact c = new Contact("RODRIGUEZ", "Juan", "5454545");
	
	System.out.println(c);

	c.setNom("asdsad");
	c.setPrenom("asdasdaaa");
       	System.out.println(c);
	try {
	    c.setNumTel(null);
	} catch(Exception e){
	    e.printStackTrace();
	}
	
	} catch (Exception e){
	    e.printStackTrace();
	}
	

    }
}
