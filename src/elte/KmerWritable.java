package elte;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.WritableComparable;

public class KmerWritable implements WritableComparable<Object> {
	
	private IntWritable occurrence;
	private IntWritable position;
	
	public KmerWritable() { //ez nemtom kell-e
		this.occurrence = new IntWritable(0);
		this.position = new IntWritable(Integer.MAX_VALUE);
	}
	
	public KmerWritable(int position) {
		this.occurrence = new IntWritable(1);
		this.position = new IntWritable(position);
	}

	public String toString() {
		return "(" + this.occurrence + "," + this.position + ")";
	}
	
	public void incOccurence() {
		occurrence.set( occurrence.get() + 1);
	}
	
	public void setOccurence(IntWritable occurrence) {
		this.occurrence = occurrence;
	}
	
	public void setPosition(IntWritable position) {
		this.position = position;
	}

	public IntWritable getPosition() {
		return this.position;
	}
	
	public IntWritable getOccurrence() {
		return this.occurrence;
	}
	
	
	public void readFields(DataInput in) throws IOException {
		this.occurrence.readFields(in);
		this.position.readFields(in);
	}
	
	public void write(DataOutput out) throws IOException {
		this.occurrence.write(out);
		this.position.write(out);
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

