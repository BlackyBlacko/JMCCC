package com.github.to2mbn.jmccc.mcdownloader.download;

import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * A download session used to handle received data and write them to the download target.
 * <p>
 * A session will be created when the download begins, and be destroyed when the download completes or fails. Once the
 * download session has been created, one of the following methods {@link #completed()}, {@link #failed(Throwable)} or
 * {@link #cancelled()} must be called.
 * 
 * @author yushijinhun
 */
public interface DownloadSession {

	/**
	 * Calls when receiving a part of data.
	 * 
	 * @param data the data
	 * @throws IOException if an I/O error occurs
	 */
	void receiveData(ByteBuffer data) throws IOException;

	/**
	 * Calls when all the data has been received successfully.
	 * <p>
	 * Notes for implementation: In this method you should close the opened resources.
	 * 
	 * @throws IOException if an I/O error occurs
	 */
	void completed() throws IOException;

	/**
	 * Calls when an error occurs during downloading.
	 * <p>
	 * Notes for implementation: In this method you should close the opened resources.
	 * 
	 * @param e the thrown exception
	 * @throws IOException if an I/O error occurs
	 */
	void failed(Throwable e) throws IOException;

	/**
	 * Calls when the download has been cancelled.
	 * <p>
	 * Notes for implementation: In this method you should close the opened resources.
	 * 
	 * @throws IOException if an I/O error occurs
	 */
	void cancelled() throws IOException;

}
