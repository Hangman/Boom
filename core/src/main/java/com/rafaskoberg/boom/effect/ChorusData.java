package com.rafaskoberg.boom.effect;

/**
 * The chorus effect essentially replays the input audio accompanied by another slightly delayed version of the signal, creating a
 * ‘doubling’ effect. This was originally intended to emulate the effect of several musicians playing the same notes simultaneously, to
 * create a thicker, more satisfying sound. To add some variation to the effect, the delay time of the delayed versions of the input signal
 * is modulated by an adjustable oscillating waveform. This causes subtle shifts in the pitch of the delayed signals, emphasizing the
 * thickening effect.
 */
public class ChorusData implements BoomEffectData {
    /**
     * 0 = sinusoid, 1 = triangle<br> This property sets the waveform shape of the LFO that controls the delay time of the delayed signals.
     */
    public int waveForm = 1;

    /**
     * Range: -180 - 180, Default: 90<br> This property controls the phase difference between the left and right LFO’s. At zero degrees the
     * two LFOs are synchronized. Use this parameter to create the illusion of an expanded stereo field of the output signal.
     */
    public int phase = 90;

    /**
     * Range: 0.0 - 10.0, Default: 1.1<br> This property sets the modulation rate of the LFO that controls the delay time of the delayed
     * signals.
     */
    public float rate = 1.1f;

    /**
     * Range: 0.0 - 1.0, Default: 0.1<br> This property controls the amount by which the delay time is modulated by the LFO.
     */
    public float depth = 0.1f;

    /**
     * Range: -1.0 - 1.0, Default: 0.25<br> This property controls the amount of processed signal that is fed back to the input of the
     * chorus effect. Negative values will reverse the phase of the feedback signal. At full magnitude the identical sample will repeat
     * endlessly. At lower magnitudes the sample will repeat and fade out over time. Use this parameter to create a “cascading” chorus
     * effect.
     */
    public float feedback = 0.25f;

    /**
     * Range: 0.0 - 0.016, Default: 0.016<br> This property controls the average amount of time the sample is delayed before it is played
     * back, and with feedback, the amount of time between iterations of the sample. Larger values lower the pitch. Smaller values make the
     * chorus sound like a flanger, but with different frequency characteristics.
     */
    public float delay = 0.016f;

    public ChorusData() {
    }

    public ChorusData(int waveForm, int phase, float rate, float depth, float feedback, float delay) {
        this.waveForm = waveForm;
        this.phase = phase;
        this.rate = rate;
        this.depth = depth;
        this.feedback = feedback;
        this.delay = delay;
    }

    @Override
    public EffectType getType() {
        return EffectType.CHORUS;
    }
}
