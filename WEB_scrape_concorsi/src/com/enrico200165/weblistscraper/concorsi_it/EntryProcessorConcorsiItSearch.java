package com.enrico200165.weblistscraper.concorsi_it;

import java.net.URI;

import com.enrico200165.weblistscraper.common.WEBUtils;
import org.apache.log4j.Logger;
import org.jsoup.nodes.Element;

import com.enrico200165.weblistscraper.concorsi_it.entities.Concor;
import com.enrico200165.weblistscraper.configs.PageConfigABC;
import com.enrico200165.weblistscraper.session.SessionManagerAbstr;

public class EntryProcessorConcorsiItSearch extends  EntryProcessorConcorsiBase {

	public EntryProcessorConcorsiItSearch(SessionManagerAbstr smPar, PageConfigABC tCfgpar) {
		super(smPar,tCfgpar);
	}

	
	@Override
	public boolean fillEntrySpecific(Concor conc , Element entryRawHTML, String fullURL, Object otherParams, boolean excludeIt) {
		

//		log.info("raw Element: \n" + entryRawHTML);

		
		conc.appendToAnn(" SEARCH-List");
		
		String titolo = WEBUtils.evSelTxt(entryRawHTML, "li > a:nth-child(2)");
		conc.setTitle(titolo);

		// --- Siste (host only) ----
		conc.setSite(pageConfig.getHostConfig().getHost());

		// --- table URL ---
		conc.setTableUrl(fullURL);

		// inernal URL
		String relURL = WEBUtils.evSelAttrTxt(entryRawHTML, "li > a:nth-child(2)", "href");
		if (relURL != null) {
			URI uri = pageConfig.getHostConfig().getBaseHostURI();
			String intUrl = uri.getScheme() + "://" + uri.getAuthority();
			intUrl += relURL;
			conc.setInfoInternURL(intUrl);
		} else {
			log.warn("unable to read internal URL");
		}

		// --- summary
		conc.setSommario("da implementare");
		return true;
	}

	
	
	private static org.apache.log4j.Logger log = Logger.getLogger(EntryProcessorConcorsiItSearch.class);
}
