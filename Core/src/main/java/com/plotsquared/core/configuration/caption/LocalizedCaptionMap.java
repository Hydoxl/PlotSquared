/*
 *       _____  _       _    _____                                _
 *      |  __ \| |     | |  / ____|                              | |
 *      | |__) | | ___ | |_| (___   __ _ _   _  __ _ _ __ ___  __| |
 *      |  ___/| |/ _ \| __|\___ \ / _` | | | |/ _` | '__/ _ \/ _` |
 *      | |    | | (_) | |_ ____) | (_| | |_| | (_| | | |  __/ (_| |
 *      |_|    |_|\___/ \__|_____/ \__, |\__,_|\__,_|_|  \___|\__,_|
 *                                    | |
 *                                    |_|
 *            PlotSquared plot management system for Minecraft
 *                  Copyright (C) 2020 IntellectualSites
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.plotsquared.core.configuration.caption;

import com.plotsquared.core.player.PlotPlayer;

import java.util.Locale;
import java.util.Map;

public class LocalizedCaptionMap implements CaptionMap {

    private final Locale locale;
    private final Map<TranslatableCaption, String> captions;

    public LocalizedCaptionMap(Locale locale, Map<TranslatableCaption, String> captions) {
        this.locale = locale;
        this.captions = captions;
    }

    @Override public String getMessage(TranslatableCaption caption) {
        return this.captions.get(caption);
    }

    @Override public String getMessage(TranslatableCaption caption, PlotPlayer<?> context) {
        return getMessage(caption); // use the translation of this locale
    }

    @Override public boolean supportsLocale(Locale locale) {
        return this.locale.equals(locale);
    }

    @Override public Locale getLocale() {
        return this.locale;
    }

}
