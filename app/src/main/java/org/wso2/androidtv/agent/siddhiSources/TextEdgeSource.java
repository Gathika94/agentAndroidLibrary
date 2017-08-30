package org.wso2.androidtv.agent.siddhiSources;

/**
 * Created by gathikaratnayaka on 8/2/17.
 */

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;


import org.wso2.androidtv.agent.services.DeviceManagementService;
import org.wso2.siddhi.annotation.Example;
import org.wso2.siddhi.annotation.Extension;
import org.wso2.siddhi.core.config.SiddhiAppContext;
import org.wso2.siddhi.core.event.Event;
import org.wso2.siddhi.core.exception.ConnectionUnavailableException;
import org.wso2.siddhi.core.stream.input.source.Source;
import org.wso2.siddhi.core.stream.input.source.SourceEventListener;
import org.wso2.siddhi.core.util.config.ConfigReader;
import org.wso2.siddhi.core.util.transport.OptionHolder;

import java.util.Map;

@Extension(
        name = "textEdge",
        namespace="source",
        description = "Get event streams from edge devices as text",
        examples = @Example(description = "TBD",syntax = "TBD")
)

public class TextEdgeSource extends AbstractEdgeSource{




    @Override
    public void init(SourceEventListener sourceEventListener, OptionHolder optionHolder, String[] strings, ConfigReader configReader, SiddhiAppContext siddhiAppContext) {
        super.init(sourceEventListener,optionHolder,strings,configReader,siddhiAppContext);

    }


    @Override
    public Class[] getOutputEventClasses() {
        return new Class[]{Event[].class, Event.class};
    }

    @Override
    public void connect(Source.ConnectionCallback connectionCallback) throws ConnectionUnavailableException {
            DeviceManagementService.connectToSource(sourceEventListener);
    }

    @Override
    public void disconnect() {
            DeviceManagementService.disConnectToSource();
    }

    @Override
    public void destroy() {

    }

    @Override
    public void pause() {
            DeviceManagementService.disConnectToSource();
    }

    @Override
    public void resume() {
            DeviceManagementService.connectToSource(sourceEventListener);
    }

    @Override
    public Map<String, Object> currentState() {
        return null;
    }

    @Override
    public void restoreState(Map<String, Object> map) {

    }






}
