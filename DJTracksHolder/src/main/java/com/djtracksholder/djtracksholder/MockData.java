package com.djtracksholder.djtracksholder;

import android.content.Context;

import com.djtracksholder.djtracksholder.com.djtracksholder.beans.TrackInfo;

import java.util.List;

/**
 * Created by Vadym_Vykhrystiuk on 12/18/13.
 */
public class MockData {
    public static String ok;
    public static List<TrackInfo> allTracks;

    public static int getCdCount() {
        return cdCount;
    }
    private static int position = 0;
    public static int getPosition() {
        return position;
    }

    public static void setPosition(int cdPosition) {
        position = cdPosition;
    }

    public static Context context;

    public static int cdCount = 48;
    public final static String DATA = "" +
            "[CD]:1;" +
            "1: Seven - Go To War;" +
            "2: Disonata & Klax - Lost Souls;" +
            "3: Wayfarer - Shaman;" +
            "4: Quantum Soul - Underworld;" +
            "5: Dubtek & Chewie - Primitive;" +
            "6: Distance feat Stepa - Gorilla Force;" +
            "7: Distance feat Stepa - Set You Free;" +
            "8: Badklaat & Disonata - Colossus;" +
            "9: Badklaat - Eville;" +
            "[CD]:2;" +
            "1: Nourma - Blackhole (Reamz Remix);" +
            "2: Brains - Blood Pressure (Matt U Remix);" +
            "3: Sleeper - Species;" +
            "4: Sleeper - On The Inside;" +
            "5: Biome - Black Widow;" +
            "6: Bulletproof ft Truth - One By One;" +
            "7: Amit - Human Warfare;" +
            "8: Amit ft. Rani - No Mercy;" +
            "[CD]:3;" +
            "1: Matt U - Hammerhead (vocal);" +
            "2: Matt U - Danger (vocal);" +
            "3: Ipman - In Atari;" +
            "4: Ipman - Messenger;" +
            "5: Killawatt - Rolling Dunes (Ipman Remix);" +
            "6: DCult & Beezy - Spoils Of War;" +
            "7: DCult & Beezy - The Condemned;" +
            "8: Demon & Chapta - Fate;" +
            "9: TMSV - Damage;" +
            "10: TMSV - Haze (LX ONE Remix);" +
            "11: TMSV - Haze;" +
            "12: Thirteen - Things To Come;" +
            "[CD]:4;" +
            "1: Truth - Chicks n Drugs;" +
            "2: DJ Madd - The Life You Chose (Distance Remix);" +
            "3: Distance - Victim Support;" +
            "4: J Kenzo - Enter Valarak;" +
            "5: Sukh Knight - Pai Mei Technique;" +
            "6: Rekta - Tugboat;" +
            "7: Juss B - Concentration (Shu Remix);" +
            "8: Shu - Albae;" +
            "9: Shu - Collosseum;" +
            "10: Shu - Collosseum (Love The Cook Remix);" +
            "11: Shu & Ziplokk - Karakorum;" +
            "[CD]:5;" +
            "1: Wheelton - Rhythm;" +
            "2: Wheelton - The Future;" +
            "3: Wheelton - Horizon;" +
            "4: Wheelton - Twisted;" +
            "5: Wheelton - The Horror;" +
            "6: Wheelton - Many Years Ago;" +
            "7: Wheelton - Undeprecated;" +
            "8: Kaiju - Clang;" +
            "9: Kaiju - M16;" +
            "10: Proxima - Formal Junction;" +
            "11: Proxima - Grunge;" +
            "12: Icicle & Proxima - Breathing Again;" +
            "13: J Kenzo - Magneto (Feel It);" +
            "[CD]:6;" +
            "1: Amit - Acid Trip;" +
            "2: TMSV ft. Beezy - Crashing;" +
            "3: TMSV - Explain;" +
            "4: TMSV - Too Much;" +
            "5: Cyberoptics - The Artifact (Truth Remix);" +
            "6: Digid - The Void;" +
            "7: Digid - Down Under;" +
            "8: Nourma - You In Me (Cya Remix unfinished);" +
            "[CD]:7;" +
            "1: J Kenzo - Statement Of Intent;" +
            "2: J Kenzo - Eyes Wide Open;" +
            "3: J Kenzo - Semtex;" +
            "4: J Kenzo - Invaderz;" +
            "5: J Kenzo - Ruffhouse;" +
            "6: J Kenzo - No Mans Land;" +
            "7: J Kenzo - Contagion;" +
            "8: J Kenzo - Body Heat;" +
            "9: J Kenzo - Iron Clad;" +
            "10: J Kenzo - Engage;" +
            "[CD]:8;" +
            "1: Asylum - Embryo;" +
            "2: Asylum - Germinate;" +
            "3: District - Transmission;" +
            "4: District - Kraken;" +
            "5: Sleeper - Zombies;" +
            "6: Sleeper - Scanners;" +
            "7: Sleeper - Narrow;" +
            "8: Mishva - Galaxies;" +
            "9: Mishva - Galaxies (Imprint Remix);" +
            "10: Youngsta & LX One - Responsibility;" +
            "11: Matta - Stalker;" +
            "12: Specters - Four Beasts;" +
            "13: Dubfreq ft Fantan Mojah - Hail Di King;" +
            "[CD]:9;" +
            "1: Perverse - Echolocation;" +
            "2: Perverse - Somber;" +
            "3: Perverse - Tempest;" +
            "4: Youngsta - Destruction;" +
            "5: Youngsta - Poseidon;" +
            "6: Deafblind - What Everyone Sees;" +
            "7: Deafblind & Format - My Fate;" +
            "8: Format - Battalion;" +
            "9: Deafblind - Mute;" +
            "10: Locust. - Andromeda;" +
            "[CD]:10;" +
            "1: Killawatt & Core - Black Mamba;" +
            "2: Killawatt & Core - Shaanxi;" +
            "3: Killawatt & Core - Akusala;" +
            "4: Amit ft Rani - Color Blind;" +
            "5: Amit - Killer Driller;" +
            "6: Lurka & Commodo - Capisce;" +
            "7: Lurka & Commodo - Glue Shift Riddim;" +
            "8: Zomby - Spliff Dub (Sukh Knight);" +
            "9: Commit - Remorse old;" +
            "[CD]:11;" +
            "1: Klax - Illusion Of Gaia;" +
            "2: Hidden Element - Dont Follow Them;" +
            "3: Shu & Dyna - Deepak;" +
            "4: Reamz - Crux;" +
            "5: Reamz - Eclipse;" +
            "6: Reamz - Falsify;" +
            "7: Reamz - Senzuri;" +
            "8: Commit - Eyes Down;" +
            "9: Locust. - Sonar;" +
            "10: Blackleg - Reality;" +
            "[CD]:12;" +
            "1: Kryptic Minds - Nebula;" +
            "2: Kryptic Minds - To Feel;" +
            "3: Kryptic Minds - Badman VIP;" +
            "4: Kryptic Minds - Namaste;" +
            "5: Dubfreq - Dama Blanca;" +
            "6: Dubfreq ft Aiva - Heartbreak;" +
            "7: Dubfreq - Metaphysics;" +
            "8: Dubfreq - Coercion;" +
            "9: Truth - Medusa;" +
            "10: VIVEK - Over My Head (vocal);" +
            "[CD]:13;" +
            "1: Matt U - Straightened;" +
            "2: Matt U - Mindgames;" +
            "3: Matt U - Caverman;" +
            "4: Nightshade & Espionage - Common Thread;" +
            "5: Soulware - Te Ao Marama;" +
            "6: Soulware - The Day That Didnt Down;" +
            "7: Soulware - The Long Road Home;" +
            "8: Soulware - Vertigo;" +
            "9: Soulware - Make A Change;" +
            "10: Optimus Gryme - Emotions (Soulware Remix);" +
            "[CD]:14;" +
            "1: Phaeleh - Untitled 333;" +
            "2: Phaeleh - Tachi;" +
            "3: J One - All I Need (Phaeleh Remix);" +
            "4: F One - Mutation Theory;" +
            "5: Benga - The UK;" +
            "6: Crystal Fighters - Follow (Roksonix Remix);" +
            "8: IBenji - Tales From The Darkside (Tim Ismag Remix);" +
            "[CD]:15;" +
            "1: Disonata & Klax - Lost Souls (Prerelease);" +
            "2: Kial - Transition of Perspective;" +
            "3: Klax - Lost Levels;" +
            "4: Klax - Jerico;" +
            "5: Asylum - Blindfold;" +
            "6: Asylum - Salvage;" +
            "7: Demon - Blood Sport;" +
            "[CD]:16;" +
            "1: Sukh Knight - Ganja Dub;" +
            "2: Sukh Knight - Hands In The Pocket;" +
            "3: Sukh Knight - Lick It;" +
            "4: Sukh Knight - Benease Your Bluse;" +
            "5: Sukh Knight - Up In Smoke;" +
            "6: Sukh Knight - Faith;" +
            "[CD]:17;" +
            "1: Boot & Tzr - Across Oceans;" +
            "2: Boot & Tzr - Hagakure;" +
            "3: Boot & Tzr - Perceived Reality;" +
            "4: Boot & Tzr - Tower Of Silence;" +
            "5: Seven & Youngsta - Masai Mara VIP;" +
            "6: Asylum - Zero Gravity;" +
            "7: Chewie & Mykal Rose - Silver & Gold;" +
            "8: Taiko - Spray Can;" +
            "9: Klax - Link To The Past;" +
            "10: Dubtek - Kuiper Belt;" +
            "11: Seven & Dubtek - Stratosfear;" +
            "12: Seven - Walter White (Truth Remix);" +
            "13: Bisweed - Catacombs;" +
            "14: Bisweed - Tsar Bomba;" +
            "[CD]:18;" +
            "1: Distance - Meanstreak;" +
            "2: Distance - Mind Control;" +
            "3: Distance - Drawn;" +
            "4: Distance - Knowing;" +
            "5: Killawatt - Critters;" +
            "6: Killawatt - Floating Weight;" +
            "7: Biome - Minus;" +
            "8: Biome - Moody;" +
            "9: Sleeper - Kurawai;" +
            "[CD]:19;" +
            "1: Chewie - Adagio For Dub;" +
            "2: Chewie - Outpost 31;" +
            "3: Chewie - Slipstream;" +
            "4: Chewie - Survival;" +
            "5: Chewie - Survival (Riskotheque Remix);" +
            "6: Sook - Seek n Dream;" +
            "7: Sook - The Wren;" +
            "8: Sook - Magnetic Anomaly;" +
            "9: Sook - Never Knows (Boot Remix);" +
            "10: Dubtek - Hemiosphere;" +
            "11: Boot - Methods Of Control;" +
            "12: Void - Commercian Shade;" +
            "13: Saviour - Fire And Forget;" +
            "14: The SubDivision - The Calm Before The Storm;" +
            "[CD]:20;" +
            "1: Perverse - Tesla;" +
            "2: Perverse - Timelapse;" +
            "3: Perverse - Unexpected;" +
            "4: Biome - Black Widow;" +
            "5: Biome - Misery;" +
            "6: Biome - Quasar;" +
            "7: Biome - Light;" +
            "8: Genetix - Going In;" +
            "9: Genetix - 24 7 Reflex;" +
            "[CD]:21;" +
            "1: Daega Sound - Fox Wings;" +
            "2: Intex Systems - Titan;" +
            "3: Psymbionic - Ride With Me (Truth Remix);" +
            "4: Truth -World Is Spining;" +
            "5: DJ Madd - Dubmarine (Kryptic Minds Remix);" +
            "6: DJ Madd - Good Old Days;" +
            "7: The Bassist - Rida;" +
            "8: Gatekeeper - Rawtones (Koan Sounds & Asa Remix);" +
            "[CD]:22;" +
            "1: Black Sun Empire - The Invasion;" +
            "2: Black Sun Empire - Dyneema;" +
            "3: Babylon System - Our Moment;" +
            "4: Matt U - Victim;" +
            "5: Tyrant - Section 9;" +
            "6: Tyrant - Section 9 Remix;" +
            "7: DJ Fresh - Chacruna;" +
            "8: DJ Fresh - Fight;" +
            "9: Lonestar - Vibes Up;" +
            "10: Lonestar - Think About It;" +
            "11: Lonestar - Guitar;" +
            "12: The Qemists - Renegade VIP;" +
            "13: Benga - Katy On A Mission;" +
            "[CD]:23;" +
            "1: DJ Madd - The Real & The Shadow;" +
            "2: DJ Madd - Deeply;" +
            "3: DJ Madd - Riginal;" +
            "4: DJ Madd - Body Pop;" +
            "5: DJ Madd & LX One - Program;" +
            "6: DJ Madd - No Tomorrow;" +
            "7: DJ Madd - Bristol 2 Budapest;" +
            "8: DJ Madd - Junglist;" +
            "9: DJ Madd - The Life You Chose;" +
            "10: DJ Madd - Kensai Avenue;" +
            "11: DJ Madd - Moving On;" +
            "12: DJ Madd - Kyoto Station;" +
            "13: DJ Madd - Everything Changes;" +
            "[CD]:24;" +
            "1: Perverse & Ollie - Shaded;" +
            "2: Perverse - Glacier;" +
            "3: Amit ft Rani - Stay With Me;" +
            "4: Killawatt - Muggy;" +
            "5: Kryptic Minds - The Talisman;" +
            "6: Minikin - Drugz;" +
            "7: Minikin - Hardbass;" +
            "8: True Tiger - Eye Ball;" +
            "9: True Tiger - Motor Oil;" +
            "10: True Tiger - Ghost;" +
            "11: Paranoise Collision - Open Fire (Riskotheque Remix);" +
            "12: Triage & Chewie - Tesseract;" +
            "13: Psymbonic - Rode With Me (Truth Remix);" +
            "[CD]:25;" +
            "1: Commodo - Northern Soul;" +
            "2: Commodo - So Clear;" +
            "3: Tzr - Headhunter (Sook Remix);" +
            "4: Exez - The Lynch Law;" +
            "5: Ipman - Mob Mentality;" +
            "6: Killawatt & Ipman - Xibalba;" +
            "7: Truth - Under Current;" +
            "8: Truth - Lab Rat;" +
            "9: Truth - Wicked Vibe Broccoli;" +
            "10: Truth - Indigo Mood;" +
            "11: i3i3 - Let De Beat Hit Em;" +
            "12: Remembrance - 6 Million Wayz;" +
            "13: Remembrance - Black Sun;" +
            "[CD]:26;" +
            "1: Boot - Colder Now;" +
            "2: Boot - Debased;" +
            "3: Boot - Shudder;" +
            "4: Boot - Structural Function;" +
            "5: Boot - Unit Zero;" +
            "6: Tallan - Before You Speak;" +
            "7: Tallan - East;" +
            "8: DCult - Darkness;" +
            "9: Demon - Cardiac Attack (DCult Remix);" +
            "10: District - Painting The Mind;" +
            "11: District - Modulate;" +
            "12: District - Backwards;" +
            "[CD]:27;" +
            "1: Matt U - Whyle The Fuck Out;" +
            "2: Kryptic Minds - Six Degrees;" +
            "3: Kryptic Minds - Hybrid (Biome Remix);" +
            "4: Kryptic Minds - Rubberman;" +
            "5: DJ Madd - Difference;" +
            "6: DJ Madd - Difference (J Kenzo Remix);" +
            "7: Klax - Dead Space;" +
            "8: Numbernin6 - She;" +
            "9: Numbernin6 - Not This Time;" +
            "10: TEASE - 1;" +
            "[CD]:28;" +
            "1: Truth - Babylon London;" +
            "2: Truth - Red Light;" +
            "3: Apatic - Modern Criminal;" +
            "4: Apatic - Secret Doctrine;" +
            "5: Imaginary Friend & UNCO - Bad Dreams Factory (Apatic Remix);" +
            "6: Commit & Histibe - 2359;" +
            "7: Biome & Demon - Incubus;" +
            "8: Biome & Demon - Symmetry;" +
            "9: J Kenzo - Invaderz;" +
            "10: Widowmaker - Forgotten Ruin;" +
            "[CD]:29;" +
            "1: Boot - The Rift;" +
            "2: Boot - Beyond The Heliosphere;" +
            "3: Boot - Blood Moon;" +
            "4: Boot - Vision Quest;" +
            "5: Killawatt - Press On;" +
            "6: Killawatt - Tantra;" +
            "7: Biome - Future Past;" +
            "8: True Tiger - Bloodshot;" +
            "9: Prodigy - Smack My Bitch Up (Noisia Remix);" +
            "[CD]:30;" +
            "1: Artikal - Alone In The Darkness (DJ Madd Remix);" +
            "2: Artikal - Voyager;" +
            "3: Matt U - Victim;" +
            "4: Matt U - Mute Soul;" +
            "5: Cardopusher - Parilla;" +
            "6: Truth - Direct Blow;" +
            "7: Truth - Snake;" +
            "8: Ed Solo - Egyptian Horns;" +
            "[CD]:31;" +
            "1: Truth - Gaza;" +
            "2: Truth - Gaza (Perverse Remix);" +
            "3: Truth ft Yayne - Rain Dancer;" +
            "4: Soap Dodgers - Ill Minded;" +
            "5: Soap Dodgers - Contact;" +
            "6: District - Proof;" +
            "7: Aeolho - 2054;" +
            "8: Sook - Dead Star;" +
            "9: Demon - Bone Yard;" +
            "[CD]:32;" +
            "1: Benton - Fathers Son;" +
            "2: Benton - Believe;" +
            "3: Benton - Hermans Hideout;" +
            "4: Benton - Defect Mind;" +
            "5: Benton - 20 20 VIP;" +
            "6: Benton - The Prey;" +
            "7: Benton - We Are Both Lost;" +
            "8: Benton - Virus;" +
            "9: Benton - Snowfall 07;" +
            "10: Benton - Joi;" +
            "11: The Kemistry - The Core (Benton Remix);" +
            "12: Thelem - Drones (Benton Remix);" +
            "[CD]:33;" +
            "1: Genetix - Installation;" +
            "2: Genetix - Natural State;" +
            "3: Genetix - Decoding;" +
            "4: Bunzer0 - Ambivalent;" +
            "5: DJ Madd - Pitfall (Phaeleh Remix);" +
            "6: K Lone - Rapid Eye Movement;" +
            "7: Tallan - Tahi;" +
            "8: Seahorse - To Be One;" +
            "9: Soul Captive - Survival;" +
            "[CD]:34;" +
            "1: DJ Madd - Blank Space;" +
            "2: DJ Madd - Pitfall;" +
            "3: DJ Madd - Murder 96;" +
            "4: Phaeleh & DJ Madd - Ritual;" +
            "5: Seven - Calculated;" +
            "6: Phaeleh - Next Phase;" +
            "7: DJ Madd - Swinger;" +
            "8: MRK1 - Download The World;" +
            "9: Mr Lager - Tell Me;" +
            "10: Dubtek - Mecca (Gravity Remix);" +
            "[CD]:35;" +
            "1: Kryptic Minds - Brief Passing;" +
            "2: Kryptic Minds - The Things They Left Behind;" +
            "3: Kryptic Minds - Just After Sunset;" +
            "4: Kryptic Minds - Fade To Nothing;" +
            "5: Kryptic Minds - No More No Less;" +
            "6: Kryptic Minds ft Alys Be - Cant Sleep;" +
            "7: Kryptic Minds - Alone;" +
            "8: Kryptic Minds - Myth;" +
            "9: Kryptic Minds - The Fifth;" +
            "10: Kryptic Minds - Depth Of Field;" +
            "11: Kryptic Minds ft Youngsta - Arcane;" +
            "[CD]:36;" +
            "1: Phaeleh - Caustic Storm;" +
            "2: Phaeleh - From A Distance;" +
            "3: Phaeleh - In The Twilight;" +
            "4: Phaeleh - Perilous;" +
            "5: Phaeleh - Should Be True;" +
            "6: Phaeleh - The Cold In You;" +
            "7: Phaeleh - Think About It;" +
            "8: Truth - Soundsystem;" +
            "9: Truth & Organikismness - Devils Eye;" +
            "[CD]:37;" +
            "1: Biome - The Fear Of The Future;" +
            "2: Biome - Industrial;" +
            "3: Boot - Dark Things;" +
            "4: J Kenzo - Ruffhouse;" +
            "5: J Kenzo - Therapy;" +
            "6: Skream - Abstruse;" +
            "7: Tallan - Left One;" +
            "8: Tallan - Border Control;" +
            "9: Tallan - Sweeper;" +
            "10: Tallan - Dreamer;" +
            "11: Bulletproof & Truth - Avalanche;" +
            "[CD]:38;" +
            "1: Kahn ft Flowdan - Badman City;" +
            "2: Matt U - Hammerhead (Instrumental);" +
            "3: Matt U - Danger (Instrumental);" +
            "4: Content - Osmosis VIP;" +
            "5: Boot & TZR - Pathetic Earthlings;" +
            "6: Biak - Ancient Crafts;" +
            "7: Babylon System & SPL - Hypnosis;" +
            "8: Crushington - Hangman;" +
            "9: Crushington - Voodoo Skank;" +
            "10: Habstract - Paris Vendetta;" +
            "11: Habstract - 1990;" +
            "12: Kahn - Illy;" +
            "13: Kahn - Tehran;" +
            "[CD]:39;" +
            "1: Ipman - Mob Mentality;" +
            "2: Killawatt & Ipman - Xibalba;" +
            "3: Distance - Aftershock;" +
            "4: Tunnige & Distance - Blame;" +
            "5: DJ Madd - Deeply;" +
            "6: DJ Madd - Riginal;" +
            "7: Saviour - Burst Into Fire;" +
            "8: Phaeleh - Fuzzbox;" +
            "9: Unknown - Funny Unknown;" +
            "[CD]:40;" +
            "1: Biome & Fallen 45 - Searching;" +
            "2: Crazy D - If I Want;" +
            "3: Kinzy - Dirty Ladies;" +
            "4: Konvex - Black Hole;" +
            "5: Twisted & Racoon - Secluded (ft Beezy);" +
            "6: Twisted & Racoon - Split Blade;" +
            "7: Widowmaker - Serpent;" +
            "8: Wayfarer - Afterlight;" +
            "9: Wayfarer - Azuma;" +
            "10: Wayfarer - Zeg;" +
            "11: Wayfarer - Nomad;" +
            "12: Thelem & T Man - Bring Me Down;" +
            "13: Thelem & T Man - False Imprint;" +
            "[CD]:41;" +
            "1: Sleeper & District - Innate;" +
            "2: Sleeper & District - Kuduro;" +
            "3: Sleeper & District - Overflow;" +
            "4: Sleeper & District - Psychosis;" +
            "5: Sleeper & District - Ressurection;" +
            "6: Sleeper & District - War;" +
            "7: J Kenzo - Ricochet;" +
            "8: J Kenzo - Depth Charge;" +
            "9: Dubtek - Bonecrusher;" +
            "10: Droid Sector - Biinary Plague;" +
            "11: Boot - The Gaze;" +
            "12: Boot & Chewie - Only Me;" +
            "[CD]:42;" +
            "1: Demon - Chang Caine;" +
            "2: Reamz - DMT;" +
            "3: Reamz - Sleeping District;" +
            "4: Reamz - Frostbite;" +
            "5: Perverse - Obsidian;" +
            "6: The Bassist - Lockdown;" +
            "7: Ribs - Mollusc (Riskotheque Remix);" +
            "8: Skream - Wobble That Gut (Widowmaker Remix);" +
            "9: Black Sun Empire - Brommer;" +
            "10: Black Sun Empire - Dirty Friday;" +
            "11: Emalkay - When I Look At You;" +
            "12: Emalkay - When I Look At You (Sduk Remix);" +
            "[CD]:43;" +
            "1: Matt U - Danger (District Remix);" +
            "2: Matt U - Danger (Dyad Remix);" +
            "3: Mala - Changes (Distance Remix);" +
            "4: J Kenzo - Ricochet;" +
            "5: Wheelton - Rhythm;" +
            "6: Wheelton - The Future;" +
            "7: Proxima - Lie Detection;" +
            "8: Digid - Time Capture;" +
            "9: P Money - Dubsteppin (J Kenzo Remix);" +
            "10: Commit - Amazon;" +
            "11: Commit - Droid Dance;" +
            "12: Commit - Jupiter;" +
            "13: Nourma - Untitled (Unfinished);" +
            "[CD]:44;" +
            "1: AxH - I Feel Safe;" +
            "2: AxH - Giant Footprints;" +
            "3: AxH - Everdine;" +
            "4: Headhunter - Clone;" +
            "5: Headhunter - Projector;" +
            "6: Phaeleh - So Far Away;" +
            "7: Phaeleh - Night Lights (ft Cian Finn);" +
            "8: Phaeleh - Storm (ft Jess Mills);" +
            "9: Phaeleh - Whistling In The Dark;" +
            "10: Phaeleh - Journey;" +
            "11: Charlie P - Okay Okay;" +
            "12: Charlie P - Not Yet;" +
            "13: Charlie P - We Only Live Once;" +
            "[CD]:45;" +
            "1: Compa & Ipman - Let Them;" +
            "2: Compa - Earth Orbit;" +
            "3: Amit - Daaku;" +
            "4: Amit - Your Native God;" +
            "5: Amit - Ill Cut You Down;" +
            "6: Amit - Mr Clark;" +
            "7: The Illuminated - Vintage;" +
            "8: The Illuminated - De Dust;" +
            "9: The Illuminated - Psychonauts;" +
            "10: The Illuminated - HMQ;" +
            "11: Wheelton - Ganja;" +
            "12: Wheelton - Paranormal;" +
            "13: Black Sun Empire & Noisia - Hideous (Wheelton Remix);" +
            "[CD]:46;" +
            "1: Distance - Andromeda;" +
            "2: Distance - Untouchable;" +
            "3: Distance - Broken Dawn;" +
            "4: TMSV - The Cosmonaut;" +
            "5: Fable - Roots;" +
            "6: Matt U - Double Blind;" +
            "7: Nanobyte - Mine;" +
            "8: Nanobyte - True Story;" +
            "9: Nanobyte - Hidden Code VIP;" +
            "10: SP MC - Trust Nobody;" +
            "11: SP MC - Oh My Gosh;" +
            "12: SP MC - Hunted;" +
            "[CD]:47;" +
            "1: Biome - The Scent;" +
            "2: Nanobyte - Misplaced True;" +
            "3: Roommate & The Bassist - Rub A Dub;" +
            "4: Sukh Knight & Mensah & Squarewave - Quad Bikes VIP;" +
            "5: Katy B - Lights On (Skream Remix);" +
            "6: Katy B - On A Mission;" +
            "7: Ribs & IG88 - Mollusc (Riskotheque Remix);" +
            "8: Tallan - Hornet;" +
            "9: Shackles - Phobia;" +
            "10: Paranoise Collision - Open Fire (Riskotheque Remix);" +
            "11: True Tiger - Motor Oil;" +
            "12: Eliphino - More Than Me;" +
            "[CD]:48;" +
            "1: Commodo - Fuck Mountain;" +
            "2: Commodo - Green Piace;" +
            "3: Feonix ft Kaya - Eon Eyes;" +
            "4: Feonix ft Kaya - Eon Eyes (Deafblind Remix);" +
            "5: Feonix ft Kaya - Eon Eyes (Demon Remix);" +
            "6: Feonix ft Kaya - Eon Eyes (Slaven Remix);" +
            "7: Numa Crew - Knowledge;" +
            "8: TMSV - Tread Lighty;" +
            "[CD]:49;" +
            "1: Chewie - Isolation;" +
            "2: Asylum - Zero Gravity VIP;" +
            "3: Seven - Walter White VIP;" +
            "4: Biome - Rise Up;" +
            "5: Reamz - Comatose;" +
            "6: Reamz - Haircut;" +
            "7: Reamz - Hush Hush;" +
            "8: Reamz - Own The Game;" +
            "9: Reamz - Through The Cracks;" +
            "10: Chewie - Hammeredhead;" +
            "[CD]:50;" +
            "1: Bukez Finezt - Under Control;" +
            "2: Bukez Finezt - You Dont Belong Here;" +
            "3: Bukez Finezt - Pace Yourself;" +
            "4: Biome - Cromos;" +
            "5: Biome - Genesis;" +
            "6: Biome - Delta;" +
            "7: Biome & Fallen 45  - Lost;" +
            "8: Truth - 30 000 ft;" +
            "9: Truth - Gangsters;" +
            "10: Truth - Trenchtown;" +
            "11: Truth - Lucid;" +
            "[CD]:51;" +
            "1: District - Tempest;" +
            "2: District - Aftermath;" +
            "3: District - Roys Theme;" +
            "4: Thelem - Haunted Harmonics;" +
            "5: Thelem - Forces Of Nature;" +
            "6: Thelem - Shottaz;" +
            "7: Thelem - Obsessions;" +
            "8: Benga - Smack Your Bitch Up;" +
            "9: ASAP Rocky - Fucking Problem;" +
            "[CD]:52;" +
            "1: Reamz - Light From A Darkened Place (Ft Flipz);" +
            "2: Reamz - Modulus;" +
            "3: Reamz - Turn West;" +
            "4: Biome - Time Lapse;" +
            "5: Biome - The Watchmen;" +
            "6: Sukh Knight - Angels;" +
            "7: Sukh Knight - Chronicle;" +
            "8: True Tiger - Can You Feel The Bass (Instrumental);" +
            "9: True Tiger - Can You Feel The Bass;" +
            "10: Soulware - Drawn Together (Live);" +
            "11: Soulware - Rise Up (Studio Mix);" +
            "[CD]:53;" +
            "1: Truth - The Only Ones;" +
            "2: Truth - Them;" +
            "3: Truth - Goodbye;" +
            "4: Truth - Hollow World;" +
            "5: Asylum - Always Love;" +
            "6: Asylum - Bad Habbit;" +
            "7: Distance - Repercussions;" +
            "8: Distance - Headstrung;" +
            "9: Distance - Out Of Mind;" +
            "10: Distance - Loosen My Grip;";
}