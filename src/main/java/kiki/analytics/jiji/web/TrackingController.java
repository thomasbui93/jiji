package kiki.analytics.jiji.web;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import kiki.analytics.jiji.message.*;
import kiki.analytics.jiji.tracking.TrackingData;

@RestController
class TrackingController {

    @Autowired
    private Messenger messengerService;

    @RequestMapping(value = "/tracking", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> trackingAction(@RequestParam("apiKey") String apiKey, @RequestParam("data") String data) {
        TrackingData trackingData = new TrackingData(apiKey, data);
        boolean isSuccessfull = this.messengerService.publishTracking(trackingData);
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("status", isSuccessfull);
        return response;
    }
}