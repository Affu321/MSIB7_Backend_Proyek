package com.msib.msib.Controller;

import com.msib.msib.Service.LokasiService;
import com.msib.msib.Utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/lokasi")
public class LokasiController {
    @Autowired LokasiService lokasiService;
    @Autowired Response response;

}
