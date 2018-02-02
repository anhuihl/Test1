
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/*
 * 请使用实现:
已知项目的根目录下有一个student.txt,内容如下:
			 1       郝婷婷    女      30
			 2       赵鹏      男      35
			 3       周强      男      38
			 4       李艳欣    女      37
			 5       朱可可    女      41
			 6       张少荣    女      30
			 7       王小军    男      28
该文件中,每一行表示一个学生信息,从前往后依次是学号,姓名,姓名,年龄
要求: 
1. 读取文件内容,把每一个学生信息封装为一个学生对象,存储到ArrayList集合中
2. 打印集合中的学生信息
3. 计算平均年龄
4. 异常处理使用throws的方式

 */
public class Test {
	public static void main(String[] args)  {
		Student stu=null;
		BufferedReader br=null;
		ArrayList<Student> list = new ArrayList<Student>();
		try {
			 br = new BufferedReader(new FileReader("student.txt"));
			String line=null;
			while((line=br.readLine())!=null){
				String[] arr=line.split("\\s+");
				stu=new Student();
				stu.setId(arr[0]);
				stu.setName(arr[1]);
				stu.setSex(arr[2]);
				stu.setAge(Integer.parseInt(arr[3]));
				list.add(stu);			
			}
					
			//求年龄平均值
			int sum=0;
			for (int i = 0; i <list.size(); i++) {
				sum += list.get(i).getAge();
				//打印集合中学生
				System.out.println(list.get(i).toString());
			}
			System.out.println("avg="+sum/(list.size()));
			
		
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(br!=null)
				br.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
}
