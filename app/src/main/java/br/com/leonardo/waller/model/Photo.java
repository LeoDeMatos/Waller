package br.com.leonardo.waller.model;

import java.util.List;

/**
 * Created by Leonardo de Matos on 24/04/17.
 */

public class Photo extends BaseWallModel {
    public URLS urls;
    public List<String> tags;
    public User user;
    public Long height;
    public Long width;
}
