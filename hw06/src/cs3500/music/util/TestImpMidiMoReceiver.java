package cs3500.music.util;

import java.io.IOException;
import java.nio.CharBuffer;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Receiver;
import javax.sound.midi.ShortMessage;

/**
 * Created by isaacf on 11/12/15.
 */
public class TestImpMidiMoReceiver implements Receiver, Appendable {

  public StringBuilder log;

  public TestImpMidiMoReceiver(StringBuilder l) {
    this.log = l;
  }




  /**
   * Sends a MIDI message and time-stamp to this receiver. If time-stamping is not supported by this
   * receiver, the time-stamp value should be -1.
   *
   * @param message   the MIDI message to send
   * @param timeStamp the time-stamp for the message, in microseconds.
   * @throws IllegalStateException if the receiver is closed
   */
  @Override
  public void send(MidiMessage message, long timeStamp) {
    ShortMessage sm = (ShortMessage)message;
    try {
      this.append("note:" + sm.getData1() + " vol:" + sm.getData2() + " Time: " + timeStamp + "\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Indicates that the application has finished using the receiver, and that limited resources it
   * requires may be released or made available.
   *
   * <p>If the creation of this <code>Receiver</code> resulted in implicitly opening the underlying
   * device, the device is implicitly closed by this method. This is true unless the device is kept
   * open by other <code>Receiver</code> or <code>Transmitter</code> instances that opened the
   * device implicitly, and unless the device has been opened explicitly. If the device this
   * <code>Receiver</code> is retrieved from is closed explicitly by calling {@link MidiDevice#close
   * MidiDevice.close}, the <code>Receiver</code> is closed, too.  For a detailed description of
   * open/close behaviour see the class description of {@link MidiDevice MidiDevice}.
   *
   * @see MidiSystem#getReceiver
   */
  @Override
  public void close() {

  }

  public String toString() {
    return this.log.toString();
  }

  /**
   * Appends the specified character sequence to this <tt>Appendable</tt>.
   *
   * <p> Depending on which class implements the character sequence <tt>csq</tt>, the entire
   * sequence may not be appended.  For instance, if <tt>csq</tt> is a {@link CharBuffer} then the
   * subsequence to append is defined by the buffer's position and limit.
   *
   * @param csq The character sequence to append.  If <tt>csq</tt> is <tt>null</tt>, then the four
   *            characters <tt>"null"</tt> are appended to this Appendable.
   * @return A reference to this <tt>Appendable</tt>
   * @throws IOException If an I/O error occurs
   */
  @Override
  public Appendable append(CharSequence csq) throws IOException {
    return this.log.append(csq);
  }

  /**
   * Appends a subsequence of the specified character sequence to this <tt>Appendable</tt>.
   *
   * <p> An invocation of this method of the form <tt>out.append(csq, start, end)</tt> when
   * <tt>csq</tt> is not <tt>null</tt>, behaves in exactly the same way as the invocation
   *
   * <pre>
   *     out.append(csq.subSequence(start, end)) </pre>
   *
   * @param csq   The character sequence from which a subsequence will be appended.  If <tt>csq</tt>
   *              is <tt>null</tt>, then characters will be appended as if <tt>csq</tt> contained
   *              the four characters <tt>"null"</tt>.
   * @param start The index of the first character in the subsequence
   * @param end   The index of the character following the last character in the subsequence
   * @return A reference to this <tt>Appendable</tt>
   * @throws IndexOutOfBoundsException If <tt>start</tt> or <tt>end</tt> are negative,
   *                                   <tt>start</tt> is greater than <tt>end</tt>, or <tt>end</tt>
   *                                   is greater than <tt>csq.length()</tt>
   * @throws IOException               If an I/O error occurs
   */
  @Override
  public Appendable append(CharSequence csq, int start, int end) throws IOException {
    return this.log.append(csq, start, end);
  }

  /**
   * Appends the specified character to this <tt>Appendable</tt>.
   *
   * @param c The character to append
   * @return A reference to this <tt>Appendable</tt>
   * @throws IOException If an I/O error occurs
   */
  @Override
  public Appendable append(char c) throws IOException {
    return this.log.append(c);
  }
}
