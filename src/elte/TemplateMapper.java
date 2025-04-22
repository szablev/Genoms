package elte;

import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class TemplateMapper extends Mapper<LongWritable, Text, Text, KmerWritable> {

	public void map(LongWritable ikey, Text ivalue, Context context) throws IOException, InterruptedException {
		String row = ivalue.toString();

		for (int i = 0; i < row.length()-2; i++) {
		    String kmer = row.substring(i,i+3);
		    
		    if (kmer.contains("T")) { 
		    	context.write(new Text(kmer), new KmerWritable(i));
		    }
		}
	}
}
