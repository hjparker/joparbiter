/**
 * @author Frank Zeyda, Kun Wei
 */
package hijac.cdx;

import javax.safetycritical.Safelet;
import javax.safetycritical.MissionSequencer;
import javax.safetycritical.Terminal;
import javax.safetycritical.annotate.Level;
import javax.safetycritical.annotate.Phase;
import javax.safetycritical.annotate.SCJAllowed;
import javax.safetycritical.annotate.SCJRestricted;

import hijac.cdx.CDxMission;
import hijac.cdx.CDxMissionSequencer;

/**
 * Safelet of the parallel CDx.
 * 
 * It returns an instance of CDxMissionSequencer.
 */
public class CDxSafelet implements Safelet<CDxMission> {
	
	public static Terminal terminal = null;

	public CDxSafelet() {
	}

	public MissionSequencer<CDxMission> getSequencer() {
		return new CDxMissionSequencer();
	}

	@Override
	@SCJAllowed(Level.SUPPORT)
	@SCJRestricted(phase = Phase.INITIALIZATION)
	public void initializeApplication() {
		terminal = Terminal.getTerminal();
	}

	@Override
	@SCJAllowed(Level.SUPPORT)
	public long immortalMemorySize() {
		return 0;
	}
}
