package com.enrico200165.weblistscraper.tools;


import com.enrico200165.weblistscraper.marketingDB.ProspectCoreData;
import com.enrico200165.weblistscraper.session.SessionManagerAbstr;
import org.apache.log4j.Logger;
import org.jsoup.nodes.Element;

public class EntryIncludeFilterVanilla extends EntryIncludeFilter {

	public EntryIncludeFilterVanilla(SessionManagerAbstr smpar) {
		super(smpar);
		// TODO Auto-generated constructor stub
	}

	public boolean includeEntrySpecific(Element entry) {
		log.error("to be implemented");
		return false;
	}

	public boolean includeHTMLEntry(Element entry) {
		boolean ret = false;
		if (ret = includeEntrySpecific(entry)) {
			incrTrueEntry();
		} else {
			incrFalseEntry();
		}
		return ret;
	}

	public boolean includeProspectSpecific(ProspectCoreData prospectCastIt) {
		log.error("to be implemented");
		return false;
	}

	public boolean includeProspect(ProspectCoreData prospectCastIt) {
		boolean ret;
		if (ret = includeProspectSpecific(prospectCastIt)) {
			incrTrueProspect();
		} else {
			incrFalseProspect();
		}
		return ret;
	}

	private static org.apache.log4j.Logger log = Logger.getLogger(EntryIncludeFilterVanilla.class);

}
