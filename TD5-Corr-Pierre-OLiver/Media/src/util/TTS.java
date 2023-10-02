package util;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class TTS {
    public static void speak(String text) {
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        VoiceManager voiceManager = VoiceManager.getInstance();
        Voice voice = voiceManager.getVoice("kevin16");

        if (voice == null) {
            System.err.println("Erreur : Voix non disponible !");
            return;
        }
        voice.allocate();
        voice.speak(text);
        voice.deallocate();
    }


}
