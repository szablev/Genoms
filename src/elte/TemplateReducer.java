package elte;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class TemplateReducer extends Reducer<Text, KmerWritable, Text, KmerWritable> {

	public void reduce(Text _key, Iterable<KmerWritable> values, Context context) throws IOException, InterruptedException {
		// process values
		KmerWritable resultKmer = new KmerWritable();
		
		for (KmerWritable kmer : values) {
			if( kmer.getPosition().get() < resultKmer.getPosition().get() ) {
				resultKmer.setPosition(new IntWritable(kmer.getPosition().get()));
			}
			resultKmer.setOccurence( new IntWritable(resultKmer.getOccurrence().get() + kmer.getOccurrence().get()));; //ezt lehet lehetne rövidebben
		}
		
		if( resultKmer.getOccurrence().get()  > 100) {
			context.write(_key, resultKmer);
		}
	}
}
