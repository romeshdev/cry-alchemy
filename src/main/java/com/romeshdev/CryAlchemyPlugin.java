package com.romeshdev;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.events.GraphicChanged;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
        name = "Cry Alchemy"
)
@Slf4j
public class CryAlchemyPlugin extends Plugin {

    private static final int CRY_EMOTE_ANIMATION_ID = 860;
    private static final int LOW_LEVEL_ALCHEMY_GFX_ID = 112;
    private static final int HIGH_LEVEL_ALCHEMY_GFX_ID = 113;
    private static final int ALCHEMY_GFX_HEIGHT_OFFSET = 100;

    @Subscribe
    public void onGraphicChanged(GraphicChanged graphicChange)
    {
        var actor = graphicChange.getActor();
        var graphic = actor.getGraphic();
        if(graphic == LOW_LEVEL_ALCHEMY_GFX_ID || graphic == HIGH_LEVEL_ALCHEMY_GFX_ID)
        {
            actor.setAnimation(CRY_EMOTE_ANIMATION_ID);
            actor.setGraphic(LOW_LEVEL_ALCHEMY_GFX_ID);
            actor.setGraphicHeight(ALCHEMY_GFX_HEIGHT_OFFSET);
            actor.setSpotAnimFrame(0);
        }
    }
}
