package com.atguigu.ioc_01;

/**
 * Description:
 *
 * @Create:2023/10/16 - 16:40
 */
public class ClientService {
    private static ClientService clientService = new ClientService();
    private ClientService() {}

    public static ClientService createInstance() {

        return clientService;
    }
}
