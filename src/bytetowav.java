import javax.sound.sampled.AudioInputStream;

class bytetowav
{
long length = (long)(totalByteArray.length / audioFormat.getFrameSize());
AudioInputStream audioInputStreamTemp = new AudioInputStream(bais, audioFormat, length);
}