package chapter01_°´Ã¼ÁöÇâ¸ðµ¨¸µ.ch01_31p;

import java.util.Iterator;
import java.util.Vector;

public class Course
{
	private String name;
	private Vector<Transcript> transcripts;
	
	public Course(String name)
	{
		this.name = name;
		transcripts = new Vector<Transcript>();
	}
	
	public void addTranscript(Transcript transcript) {
		// TODO Auto-generated method stub
		transcripts.add(transcript);
	}

	public String getName()
	{
		return this.name;
	}

	public Vector<Student> getStudents() {
		// TODO Auto-generated method stub
		Vector<Student> students = new Vector<Student>();
		Iterator<Transcript> itor = transcripts.iterator();
		
		while(itor.hasNext())
		{
			Transcript tr = itor.next();
			students.add(tr.getStudent());
		}
		
		return students;
	}

	
}