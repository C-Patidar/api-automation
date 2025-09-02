package org.example;

import io.restassured.path.json.JsonPath;
import org.example.files.payload;

public class ComplexJsonParse {

	public static void main(String[] args) {

		JsonPath js = new JsonPath(payload.CoursePrice());

		//Print no. of courses returned by API

		int count = js.getInt("courses.size()");
		System.out.println("count : "+ count);

		//Print Purchase Amount

		int totalAmount  = js.getInt("dashboard.purchaseAmount");
		System.out.println("totalAmount: "+ totalAmount);

		//Print Title of the first course

		String firstCourseTitle = js.get("courses[0].title");
		System.out.println("firstCourseTitle: "+ firstCourseTitle);

		//Print All course titles and their respective Prices

		for(int i=0;i<count;i++)
		{
			String courseTitles=js.get("courses["+i+"].title");
			System.out.println(js.get("courses["+i+"].price").toString());

			System.out.println(courseTitles);

		}
		//Print no of copies sold by RPA Course

		System.out.println("Print no of copies sold by RPA Course");

		for(int i=0;i<count;i++)
		{
			String courseTitles=js.get("courses["+i+"].title");
			if(courseTitles.equalsIgnoreCase("RPA"))
			{
				int copies=js.get("courses["+i+"].copies");
				System.out.println(copies);
				break;
			}


		}



	}

}
