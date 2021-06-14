package chapter14_������Ʈ����.exercise.ex01;

import java.util.ArrayList;
import java.util.List;

public class Directory extends AbstractFile{
	private List<AbstractFile> files = new ArrayList<>();
	
	public Directory(String name)
	{
		super(name);
	}
	
	public void addEntry(AbstractFile entry)
	{
		entry.setDepth(getDepth()+1);
		files.add(entry);
	}

	public void removeEntry(Object entry)
	{
		files.remove(entry);
	}
	
	public int getSize()
	{
		int size = 0;
		for(AbstractFile entry : files)
		{
			size += entry.getSize();
		}
		return size;
	}
	
	public void print()
	{
		for(int i=0;i<getDepth();i++)
		{
			System.out.print("\t");
		}
		
		System.out.printf("[Directory] %s, Size: %d\n",getName(),getSize());
		
		for(AbstractFile entry:files)
		{
			entry.print();
		}
	}

}
