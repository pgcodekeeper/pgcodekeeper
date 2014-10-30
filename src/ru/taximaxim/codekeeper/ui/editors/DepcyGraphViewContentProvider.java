package ru.taximaxim.codekeeper.ui.editors;

import java.util.ArrayList;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.zest.core.viewers.IGraphContentProvider;
import org.eclipse.zest.core.viewers.IGraphEntityContentProvider;
import org.eclipse.zest.core.viewers.IGraphEntityRelationshipContentProvider;
import org.jgrapht.graph.DefaultEdge;

import cz.startnet.utils.pgdiff.schema.PgStatement;

public class DepcyGraphViewContentProvider extends ArrayContentProvider  implements IGraphEntityContentProvider {

    @Override
    public Object[] getConnectedTo(Object entity) {
        if (entity instanceof PgStatement){
            if (DepcyGraphView.graa != null){
                ArrayList<PgStatement> connected = new ArrayList<PgStatement>(5);
                Object[] sese = DepcyGraphView.graa.outgoingEdgesOf((PgStatement)entity).toArray();
                for (Object e : sese){
                    if (e instanceof DefaultEdge){
                        connected.add(DepcyGraphView.graa.getEdgeTarget((DefaultEdge)e));
                    }else{
                        System.err.println("WHAT");
                    }
                }
                return connected.toArray();
            }
        }
        throw new IllegalStateException("Input type is not supported");
    }

}

class DepcyGraphViewContentProvider2 extends ArrayContentProvider  implements IGraphContentProvider {

    @Override
    public Object getSource(Object rel) {
        
        return null;
    }

    @Override
    public Object getDestination(Object rel) {
        
        return null;
    }

   
}

class DepcyGraphViewContentProvider3 extends ArrayContentProvider  implements IGraphEntityRelationshipContentProvider {

    @Override
    public Object[] getRelationships(Object source, Object dest) {
        // TODO Auto-generated method stub
        return null;
    }
   
}