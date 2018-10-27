package world.attachments;

import world.objects.AbstractObject;

import java.util.ArrayList;
import java.util.List;

public class AttachmentManager {

    private final List<AbstractObject> mAttachments = new ArrayList<>();
    private final AbstractObject mObject;

    /**
     * Default constructor
     *
     * @param object the object which is having attachments
     */
    public AttachmentManager(final AbstractObject object) {
        mObject = object;
    }

    /**
     * Called for adding an attachment
     *
     * @param attachment the attachment being added
     */
    public void addAttachment(final Attachment attachment) {
        mAttachments.add(attachment);
        attachment.onAttach();
    }

    /**
     * Called for detaching an attachment
     *
     * @param attachment the attachment being detached
     */
    public void detach(final Attachment attachment) {
        attachment.onDetach();
        mAttachments.remove(attachment);
    }

    public List<AbstractObject> getAttachments() {
        return mAttachments;
    }
}
