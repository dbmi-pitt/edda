/*
 *  RapidMiner
 *
 *  Copyright (C) 2001-2011 by Rapid-I and the contributors
 *
 *  Complete list of developers available at our web site:
 *
 *       http://rapid-i.com
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Affero General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Affero General Public License for more details.
 *
 *  You should have received a copy of the GNU Affero General Public License
 *  along with this program.  If not, see http://www.gnu.org/licenses/.
 */

package edu.pitt.dbmi.edda.operator.ldaop;

import java.awt.Component;
import java.util.logging.Logger;

import com.rapidminer.datatable.DataTable;
import com.rapidminer.gui.renderer.AbstractDataTableTableRenderer;
import com.rapidminer.operator.IOContainer;

public class RendererMostProbable extends AbstractDataTableTableRenderer {
	
	private final static Logger logger = Logger.getLogger(RendererMostProbable.class .getName()); 

	public RendererMostProbable() {
		logger.fine("Constructed a " + getClass().getSimpleName());
	}

	@Override
	public String getName() {
		return "Most Probable Words";
	}

    @Override
    public Component getVisualizationComponent(Object renderable, IOContainer ioContainer) {
    	TopicModelAdapter topicModelAdapter = (TopicModelAdapter) renderable;
        return new TopicModelViewer(topicModelAdapter);
    }
	
	
	@Override
	public DataTable getDataTable(Object renderable, IOContainer ioContainer,
			boolean isRendering) {
		return new DataTableMostProbable("Most Probable Words",
				(TopicModelAdapter) renderable);
	}

}
