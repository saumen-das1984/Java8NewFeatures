package asynchronousfilechannel.example;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AsynchronousFileChannelWithFuture {

	private static final int BLOCKSIZE = 20;
	static String filePath = "C:\\Users\\saumend\\Desktop\\2020-03-31\\LiveOSDataImport.log";

	public static void main(String[] args) {
		ByteBuffer buffer = ByteBuffer.allocate(BLOCKSIZE);
		Path path = Paths.get(filePath);

		try {
			AsynchronousFileChannel asyncFileChannel = AsynchronousFileChannel.open(path);
			int curPos = 0;
			do {
				Future<Integer> fileResult = asyncFileChannel.read(buffer, curPos);
				try {
					int blockRead = fileResult.get();
					if (blockRead < 0)
						break;

					curPos += blockRead;
					buffer.flip();
					System.out.println(Charset.defaultCharset().decode(buffer));
					buffer.clear();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} while (true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
