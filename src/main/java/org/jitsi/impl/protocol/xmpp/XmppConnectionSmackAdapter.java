package org.jitsi.impl.protocol.xmpp;

import org.jitsi.protocol.xmpp.XmppConnection;
import org.jivesoftware.smack.*;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.iqrequest.IQRequestHandler;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Nonza;
import org.jivesoftware.smack.packet.Stanza;
import org.jxmpp.jid.DomainBareJid;
import org.jxmpp.jid.EntityFullJid;
import org.jxmpp.jid.parts.Resourcepart;

import java.io.IOException;

/**
 * This class is a Smack {@link org.jivesoftware.smack.XMPPConnection} that wraps a Jitsi {@link org.jitsi.protocol.xmpp.XmppConnection}.
 *
 * It is intended to be used for various Smack factory methods (typically #getInstanceFor()-styled methods).
 *
 * @author Guus der Kinderen, guus.der.kinderen@gmail.com
 */
public class XmppConnectionSmackAdapter implements XMPPConnection
{
    protected final AbstractXMPPConnection delegate;

    public XmppConnectionSmackAdapter( XmppConnection jitsiConnection )
    {
        delegate = new JitsiBasedXMPPConnection( jitsiConnection );
    }

    @Override
    public DomainBareJid getServiceName()
    {
        return delegate.getServiceName();
    }

    @Override
    public DomainBareJid getXMPPServiceDomain()
    {
        return delegate.getXMPPServiceDomain();
    }

    @Override
    public String getHost()
    {
        return delegate.getHost();
    }

    @Override
    public int getPort()
    {
        return delegate.getPort();
    }

    @Override
    public boolean isSecureConnection()
    {
        return delegate.isSecureConnection();
    }

    @Override
    public void sendNonza( Nonza element ) throws SmackException.NotConnectedException, InterruptedException
    {
        delegate.sendNonza( element );
    }

    @Override
    public boolean isUsingCompression()
    {
        return delegate.isUsingCompression();
    }

    @Override
    public String getStreamId()
    {
        return delegate.getStreamId();
    }

    @Override
    @Deprecated
    public void sendPacket( Stanza packet ) throws SmackException.NotConnectedException, InterruptedException
    {
        delegate.sendPacket( packet );
    }

    @Override
    public void sendStanza( Stanza stanza ) throws SmackException.NotConnectedException, InterruptedException
    {
        delegate.sendStanza( stanza );
    }

    @Override
    public void addConnectionListener( ConnectionListener connectionListener )
    {
        delegate.addConnectionListener( connectionListener );
    }

    @Override
    public void removeConnectionListener( ConnectionListener connectionListener )
    {
        delegate.removeConnectionListener( connectionListener );
    }

    @Override
    public StanzaCollector createStanzaCollectorAndSend( IQ packet ) throws SmackException.NotConnectedException, InterruptedException
    {
        return delegate.createStanzaCollectorAndSend( packet );
    }

    @Override
    public StanzaCollector createStanzaCollectorAndSend( StanzaFilter packetFilter, Stanza packet ) throws SmackException.NotConnectedException, InterruptedException
    {
        return delegate.createStanzaCollectorAndSend( packetFilter, packet );
    }

    @Override
    public StanzaCollector createStanzaCollector( StanzaFilter packetFilter )
    {
        return delegate.createStanzaCollector( packetFilter );
    }

    @Override
    public StanzaCollector createStanzaCollector( StanzaCollector.Configuration configuration )
    {
        return delegate.createStanzaCollector( configuration );
    }

    @Override
    public void removeStanzaCollector( StanzaCollector collector )
    {
        delegate.removeStanzaCollector( collector );
    }

    @Override
    @Deprecated
    public void addPacketListener( StanzaListener packetListener, StanzaFilter packetFilter )
    {
        delegate.addPacketListener( packetListener, packetFilter );
    }

    @Override
    @Deprecated
    public boolean removePacketListener( StanzaListener packetListener )
    {
        return delegate.removePacketListener( packetListener );
    }

    @Override
    public void addSyncStanzaListener( StanzaListener packetListener, StanzaFilter packetFilter )
    {
        delegate.addSyncStanzaListener( packetListener, packetFilter );
    }

    @Override
    public boolean removeSyncStanzaListener( StanzaListener packetListener )
    {
        return delegate.removeSyncStanzaListener( packetListener );
    }

    @Override
    public void addAsyncStanzaListener( StanzaListener packetListener, StanzaFilter packetFilter )
    {
        delegate.addAsyncStanzaListener( packetListener, packetFilter );
    }

    @Override
    public boolean removeAsyncStanzaListener( StanzaListener packetListener )
    {
        return delegate.removeAsyncStanzaListener( packetListener );
    }

    @Override
    public void addPacketSendingListener( StanzaListener packetListener, StanzaFilter packetFilter )
    {
        delegate.addPacketSendingListener( packetListener, packetFilter );
    }

    @Override
    public void removePacketSendingListener( StanzaListener packetListener )
    {
        delegate.removePacketSendingListener( packetListener );
    }

    @Override
    public void addPacketInterceptor( StanzaListener packetInterceptor, StanzaFilter packetFilter )
    {
        delegate.addPacketInterceptor( packetInterceptor, packetFilter );
    }

    @Override
    public void removePacketInterceptor( StanzaListener packetInterceptor )
    {
        delegate.removePacketInterceptor( packetInterceptor );
    }

    @Override
    public long getPacketReplyTimeout()
    {
        return delegate.getPacketReplyTimeout();
    }

    @Override
    public void setPacketReplyTimeout( long timeout )
    {
        delegate.setPacketReplyTimeout( timeout );
    }

    @Override
    public long getReplyTimeout()
    {
        return delegate.getReplyTimeout();
    }

    @Override
    public void setReplyTimeout( long timeout )
    {
        delegate.setReplyTimeout( timeout );
    }

    @Override
    public int getConnectionCounter()
    {
        return delegate.getConnectionCounter();
    }

    @Override
    public void setFromMode( FromMode fromMode )
    {
        delegate.setFromMode( fromMode );
    }

    @Override
    public FromMode getFromMode()
    {
        return delegate.getFromMode();
    }

    @Override
    public <F extends ExtensionElement> F getFeature( String element, String namespace )
    {
        return delegate.getFeature( element, namespace );
    }

    @Override
    public boolean hasFeature( String element, String namespace )
    {
        return delegate.hasFeature( element, namespace );
    }

    @Override
    public void sendStanzaWithResponseCallback( Stanza stanza, StanzaFilter replyFilter, StanzaListener callback ) throws SmackException.NotConnectedException, InterruptedException
    {
        delegate.sendStanzaWithResponseCallback( stanza, replyFilter, callback );
    }

    @Override
    public void sendStanzaWithResponseCallback( Stanza stanza, StanzaFilter replyFilter, StanzaListener callback, ExceptionCallback exceptionCallback ) throws SmackException.NotConnectedException, InterruptedException
    {
        delegate.sendStanzaWithResponseCallback( stanza, replyFilter, callback, exceptionCallback );
    }

    @Override
    public void sendStanzaWithResponseCallback( Stanza stanza, StanzaFilter replyFilter, StanzaListener callback, ExceptionCallback exceptionCallback, long timeout ) throws SmackException.NotConnectedException, InterruptedException
    {
        delegate.sendStanzaWithResponseCallback( stanza, replyFilter, callback, exceptionCallback, timeout );
    }

    @Override
    public void sendIqWithResponseCallback( IQ iqRequest, StanzaListener callback ) throws SmackException.NotConnectedException, InterruptedException
    {
        delegate.sendIqWithResponseCallback( iqRequest, callback );
    }

    @Override
    public void sendIqWithResponseCallback( IQ iqRequest, StanzaListener callback, ExceptionCallback exceptionCallback ) throws SmackException.NotConnectedException, InterruptedException
    {
        delegate.sendIqWithResponseCallback( iqRequest, callback, exceptionCallback );
    }

    @Override
    public void sendIqWithResponseCallback( IQ iqRequest, StanzaListener callback, ExceptionCallback exceptionCallback, long timeout ) throws SmackException.NotConnectedException, InterruptedException
    {
        delegate.sendIqWithResponseCallback( iqRequest, callback, exceptionCallback, timeout );
    }

    @Override
    public void addOneTimeSyncCallback( StanzaListener callback, StanzaFilter packetFilter )
    {
        delegate.addOneTimeSyncCallback( callback, packetFilter );
    }

    @Override
    public IQRequestHandler registerIQRequestHandler( IQRequestHandler iqRequestHandler )
    {
        return delegate.registerIQRequestHandler( iqRequestHandler );
    }

    @Override
    public IQRequestHandler unregisterIQRequestHandler( String element, String namespace, IQ.Type type )
    {
        return delegate.unregisterIQRequestHandler( element, namespace, type );
    }

    @Override
    public long getLastStanzaReceived()
    {
        return delegate.getLastStanzaReceived();
    }

    @Override
    public EntityFullJid getUser()
    {
        return delegate.getUser();
    }

    @Override
    public boolean isConnected()
    {
        return delegate.isConnected();
    }

    @Override
    public boolean isAuthenticated()
    {
        return delegate.isAuthenticated();
    }

    @Override
    public boolean isAnonymous()
    {
        return delegate.isAnonymous();
    }

    @Override
    public IQRequestHandler unregisterIQRequestHandler( IQRequestHandler iqRequestHandler )
    {
        return delegate.unregisterIQRequestHandler( iqRequestHandler );
    }

    private static class JitsiBasedConnectionConfiguration extends ConnectionConfiguration
    {
        protected JitsiBasedConnectionConfiguration( Builder builder )
        {
            super( builder );
        }

        public static class Builder extends ConnectionConfiguration.Builder<Builder, JitsiBasedConnectionConfiguration>
        {
            public Builder( XmppConnection jitsiConnection )
            {
                this.setXmppDomain( jitsiConnection.getUser().asDomainBareJid() );
                this.setAuthzid( jitsiConnection.getUser().asEntityBareJid() );
                this.setResource( jitsiConnection.getUser().getResourceOrNull() );
            }

            @Override
            public JitsiBasedConnectionConfiguration build()
            {
                return new JitsiBasedConnectionConfiguration( this );
            }

            @Override
            protected Builder getThis()
            {
                return this;
            }
        }
    }

    private class JitsiBasedXMPPConnection extends AbstractXMPPConnection
    {
        private final XmppConnection jitsiConnection;

        public JitsiBasedXMPPConnection( XmppConnection jitsiConnection )
        {
            super( new JitsiBasedConnectionConfiguration.Builder( jitsiConnection ).build() );
            this.jitsiConnection = jitsiConnection;
            this.connected = true;
        }

        @Override
        public boolean isSecureConnection()
        {
            throw new UnsupportedOperationException();
        }

        @Override
        protected void sendStanzaInternal( Stanza packet ) throws SmackException.NotConnectedException, InterruptedException
        {
            jitsiConnection.sendStanza( packet );
        }

        @Override
        public void sendNonza( Nonza element ) throws SmackException.NotConnectedException, InterruptedException
        {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean isUsingCompression()
        {
            throw new UnsupportedOperationException();
        }

        @Override
        protected void connectInternal() throws SmackException, IOException, XMPPException, InterruptedException
        {
            throw new UnsupportedOperationException();
        }

        @Override
        protected void loginInternal( String username, String password, Resourcepart resource ) throws XMPPException, SmackException, IOException, InterruptedException
        {
            throw new UnsupportedOperationException();
        }

        @Override
        protected void shutdown()
        {
            throw new UnsupportedOperationException();
        }
    }
}
