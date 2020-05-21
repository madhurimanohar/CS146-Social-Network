import java.util.EventListener;

/**
 * 
 * @author madhurim, Eunice Oh
 *
 */
public interface ProfileListener extends EventListener {
    public void profileRegisterOccurred(Profile p);
}