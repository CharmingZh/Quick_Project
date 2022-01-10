#### ✅Fading Explain. 

> ... Describe their impacts on the wireless channel, with the help of a sketch of BER vs Eb/No curves.

- Explain **Flat** fading and **frequency selective** fading. 

   > <table border="0">
   > <tr>
   >  <td width="50%">
   >    <p><b>Flat Fading: Flat fading is that type of fading in which all frequency components of the received signal fluctuate in the same proportions simultaneously. Multipath fading can be characterized by a coherence bandwidth, BC , which is the range of frequencies over which the channel response is relatively constant. Therefore, if the coherence bandwidth is much, much greater than the signal bandwidth, then flat fading occurs. </b></p>
   >    <p><b>Frequency Selective : frequency selective fading occurs when flat fading is not present. It affects unequally the different spectral components of a radio signal. If attenuation occurs over only a portion of the bandwidth of the signal the fading is considered to be frequency selective. </b></p>
   >  </td>
   >  <td width="50%">
   >       <img height="700" src="/Users/charminzh/Library/Application%20Support/typora-user-images/image-20220111002443059.png" /> 
   >  </td>
   > </tr>
   > </table>

- 🤔️Explain the **Rayleigh** and **Rician** fading, respectively. 

   > <table border="0">
   > <tr>
   >  <td width="50%">
   >    <p><b>1. Rayleigh fading occurs when there are multiple indirect paths between the transmitter and the receiver and no distinct dominant path, such as an LOS path. The Rayleigh model characterizes outdoor settings.  </b></p>
   >    <p><b>2. Rician fading best characterizes a situation where there is a direct LOS path in addition to a number of indirect multipath signals. The Rician model is often applicable in an indoor environment whereas. The Rician model also becomes more applicable in smaller cells or in more open outdoor environments.</b></p>
   >  </td>
   >  <td width="50%">
   >       <img height="500" src="/Users/charminzh/Library/Application%20Support/typora-user-images/image-20220111002443059.png" /> 
   >  </td>
   > </tr>
   > </table>
   >
   > The channels can be characterized by a parameter K, defined as follows:
   > $$
   > K = \frac{power\ in\ the\ dominant\ path}{power\ in\ the\ scattered\ paths}
   > $$
   >The figure shows that with a reasonably strong signal, relative to noise, a Rician channels with larger values of K exhibit provides fairly good performance.The Rayleigh channel provides relatively poor performance; this is likely to be seen for flat fading and for slow fading; in these cases, error compensation mechanisms become more desirable. 

#### ✅With the help of diagrams, explain how the ... works and the processing gain.

- Direct Sequence Spread Spectrum (**DSSS**)：

   > For direct sequence spread spectrum (DSSS), each bit in the original signal is represented by multiple bits in the transmitted signal, using a spreading code. The spreading code spreads the signal across a wider frequency band in direct proportion to the number of bits used. Therefore, a 10-bit spreading code spreads the signal across a frequency band that is approximately 10 times greater than a 1-bit spreading code.
   > Because the bits in the PN sequence are much smaller, they are sometimes called chips; the sequence is then called the chip sequence.
   >
   > <img src="https://tva1.sinaimg.cn/large/008i3skNly1gy91x624xfj31280l0q65.jpg" alt="image-20220111004030461" style="zoom:67%;" />

- Frequency Hopping Spread Spectrum (**FHSS**)：

   > With frequency hopping spread spectrum (FHSS), the signal is broadcast over a seemingly random series of radio frequencies, hopping from frequency to frequency at fixed intervals. A receiver, hopping between frequencies in synchronization with the transmitter, picks up the message. 
   > A number of channels, C, are allocated for the FH signal. The spacing between carrier frequencies and hence the width of each channel usually corresponds to the bandwidth of the input signal. The transmitter operates in one channel at a time for a fixed interval; During that interval, some number of bits is transmitted using some encoding scheme. A spreading code dictates the sequence of channels used. Both the transmitter and the receiver use the same code to tune into a sequence of channels in synchronization.
   >
   > For transmission, binary data are fed into a modulator using some digital-to-analog encoding scheme. The resulting signal is centered on some base frequency. A pseudonoise, or pseudorandom number, source serves as an index into a table of frequencies; this is the spreading code referred to previously. At each successive interval, a new carrier frequency is selected. This frequency is then modulated by the signal produced from the initial modulator to produce a new signal with the same shape but now centered on the selected carrier frequency.
   >
   > On reception, the spread spectrum signal is demodulated using the same sequence of PN-derived frequencies and then demodulated to produce the output data.
   >
   > <img src="/Users/charminzh/Library/Application%20Support/typora-user-images/image-20220111004914681.png" alt="image-20220111004914681" style="zoom: 50%;" />

#### ✅Describe the operation of ... , with the help of a diagram if necessary.

- ✅CSMA/CA

   > <table border="0">
   >   <tr>
   >     <td width="70%">
   >       <p><b>1. If initially the station senses the channel idle, it transmits its frame after a short period of time known as the Distributed Inter-frame Space (DIFS); </b></p>
   >       <p><b>2. Otherwise, the station chooses a random backoff value using binary exponential backoff and counts down this value after DIFS when the channel is sensed idle. While the channel is sensed busy, the counter value remains frozen.</b></p>
   >       <p><b>3. When the counter reaches zero, the station transmits the entire frame and then waits for an acknowledgment.</b></p>
   >       <p><b>4. If an acknowledgment is received, the transmitting station knows that its frame has been correctly received at the destination station. If the station has another frame to send, it begins the CSMA/CA protocol at step 2. If the acknowledgment isn’t received, the transmitting station reenters the backoff phase in step 2, with the random value chosen from a larger interval.</b></p>
   >     </td>
   >     <td width="30%">
   >          <img height="500" src="/Users/charminzh/Library/Application%20Support/typora-user-images/image-20220110181351623.png" /> 
   >     </td>
   >   </tr>
   > </table>

- ✅CDMA

   > In a CDMA protocol, each bit being sent is encoded by multiplying the bit by a signal (the code) that changes at a much faster rate (known as the chipping rate) than the original sequence of data bits.
   >
   > At the receiving end, the same pseudo-random code sequence is used to multiply with the received signal. For example, if the signal transmission rate is Bbit/s and m-bit code slice sequence is used, the rate is increased by m times and the bandwidth is also increased by m times by multiplying the two.
   >
   > Each station has a uniquely determined sequence of code pieces. In this example, we choose m=8.When the mobile terminal sends a "1", the m-code piece is sent.When the mobile terminal sends a "0", the inverse of the m-code piece is sent.
   >
   > For example: there are four stations for code division multiplexing communication, the sequence of code slices of the four stations is
   >
   > ```shell
   > A：(-1 -1 -1 +1 +1 -1 +1 +1)    B：(-1 -1 +1 -1 +1 +1 +1 -1)
   > C：(-1 +1 -1 +1 +1 +1 -1 -1)    D：(-1 +1 -1 -1 -1 -1 +1 -1)
   > S: (-1 +1 -3 +1 -1 -3 +1 +1)
   > ```
   >
   > Now the received code piece sequence S is` (-1 +1 -3 +1 -1 -3 +1 +1)`, By calculating:
   > $$
   > \frac18\sum_{m=1}^8A_m*S_m=\frac18(1-1+3+1-1+3+1+1)=1\\
   > \frac18\sum_{m=1}^8B_m*S_m=-1\\
   > \frac18\sum_{m=1}^8C_m*S_m=0\\
   > \frac18\sum_{m=1}^8D_m*S_m=1\\
   > $$
   > So station C did not send a message, stations A and D sent a "1" and station B sent a "0".

- ✅OFDM

   > If a channel transmits only one way signal is very wasteful, in order to be able to make full use of the bandwidth of the channel, the method of frequency division multiplexing can be used. The main idea of OFDM is that the channel is divided into several orthogonal sub-channels, and the high-speed data signals are converted into parallel low-speed sub-streams and modulated to be transmitted on each sub-channel. The orthogonal signals can be separated by using correlation techniques at the receiver side, which reduces the ISI between subchannels. The signal bandwidth on each subchannel is smaller than the correlation bandwidth of the channel, so it can be seen as flat fading on each subchannel, thus allowing inter-code crosstalk to be eliminated, and since the bandwidth of each subchannel is only a fraction of the original channel bandwidth, channel equalization becomes relatively easy.

#### ✅ALOHA

- Explain three ALOHA Access techniques in wireless data networks. What are their main disadvantages?

   > 1. Pure ALOHA protocol : 
   >    - When more than two transmitters send at the same time, packet "collision" or overlap occurs, resulting in lost or erroneous packets. The main station decodes the received packet and sends back a correct answer signal ACK if it is found to be error-free, and resends the packet until ACK is received if ACK is not received within a limited period of time after the terminal has sent the message.
   >    - Advantages：the maximum throughput rate is low, only 0.184, mainly caused by "collision" and retransmission of random delay;
   > 2. Slotted ALOHA protocol
   >    - In order to improve the throughput rate of pure ALOHA, an improved protocol is proposed, called split-gap ALOHA (or time-slotted ALOHA). According to this protocol, the channel time is divided into equal time slots, the width of which is exactly equal to the time required to transmit a packet. To avoid partial overlap when packets "collide", all transmitters are allowed to send packets only at the beginning of the time slot. 
   >    - Advantages：the complexity of the implementation increases because all transmitters in the network can only transmit signals synchronously.
   > 3. Reservation ALOHA
   >    - The protocol divides the channel time into frames and each frame into M+1 time slots, the first M time slots are used to send information packets, and the M+1 time slots are further subdivided into V sub-time slots for the transmitters in the network to send reservation signals according to the slots ALOHA, once the reservation is successful, the transmitter can use one of the free time slots in the first M+1 time slots to send information. 
   >    - Advantages：the cost is to further increase the delay and system complexity.

---

### ⚠️IEEE 802.11

#### ✅ RTS/CTS in IEEE 802.11 Standard

- The RTS/CTS Protocol is defined to solve a problem in the IEEE802.11 standard. Describe the problem and explain how the RTS/CTS Protocol solves it.

- Explain why the RTS/CTS Protocol is devised in the IEEE802.11 standard.

   > The RTS/CTS Protocol helps avoid collisions in the presence of hidden terminals. If there are two wireless stations and one AP. Both of the wireless stations are within range of the AP and both have associated with the AP. However, due to fading, the signal ranges of wireless stations are too limited to reach each other. Thus, each of the wireless stations is hidden from the other, although neither is hidden from the AP.
   >
   > Suppose Station H1 is transmitting a frame and halfway through H1’s transmission, Station H2 wants to send a frame to the AP. H2, not hearing the transmission from H1, will first wait a DIFS interval and then transmit the frame, resulting in a collision. The channel will therefore be wasted during the entire period of H1’s transmission as well as during H2’s transmission.
   >
   > In order to avoid this problem, the IEEE 802.11 protocol allows a station to use a short Request to Send (RTS) control frame and a short Clear to Send (CTS) control frame to reserve access to the channel. When a sender wants to send a DATA frame, it can first send an RTS frame to the AP, indicating the total time required to transmit the DATA frame and the acknowledgment (ACK) frame. When the AP receives the RTS frame, it responds by broadcasting a CTS frame. This CTS frame serves two purposes: It gives the sender explicit permission to send and also instructs the other stations not to send for the reserved duration.

#### ✅ Hidden Terminals in 802.11

- What are hidden terminals (in WLAN)?

   >  If there are two wireless stations and one AP. Both of the wireless stations are within range of the AP and both have associated with the AP. However, due to fading, the signal ranges of wireless stations are too limited to reach each other. Thus, each of the wireless stations is hidden from the other, although neither is hidden from the AP.
   >
   > Suppose Station H1 is transmitting a frame and halfway through H1’s transmission, Station H2 wants to send a frame to the AP. H2, not hearing the transmission from H1, will first wait a DIFS interval and then transmit the frame, resulting in a collision. The channel will therefore be wasted during the entire period of H1’s transmission as well as during H2’s transmission.

- Explain in detail how this problem is solved in the IEEE802.11 standard?

   > In order to avoid this problem, the IEEE 802.11 protocol allows a station to use a short Request to Send (RTS) control frame and a short Clear to Send (CTS) control frame to reserve access to the channel. When a sender wants to send a DATA frame, it can first send an RTS frame to the AP, indicating the total time required to transmit the DATA frame and the acknowledgment (ACK) frame. When the AP receives the RTS frame, it responds by broadcasting a CTS frame. This CTS frame serves two purposes: It gives the sender explicit permission to send and also instructs the other stations not to send for the reserved duration.

#### ✅Physical layer in the IEEE802. 11 standard.

- Describe the Physical layer specification in the IEEE802. 11a, 11b and 11g standards, respectively.

   > | Standard                    | 802.11a    | 802.11b    | 802.11g    |
   > | --------------------------- | ---------- | ---------- | ---------- |
   > | Year introduced             | 1999       | 1999       | 2003       |
   > | Maximum data transfer speed | 54 Mbps    | 11 Mbps    | 54 Mbps    |
   > | Frequency band              | 5 GHz      | 2.4 GHz    | 2.4 GHz    |
   > | Channel bandwidth           | 20 MHz     | 20 MHz     | 20 MHz     |
   > | Highest order modulation    | 64 QAM     | 11 CCK     | 64 QAM     |
   > | Spectrum usage              | OFDM       | DSSS       | DSSS, OFDM |
   > | Antenna configuration       | 1 * 1 SISO | 1 * 1 SISO | 1 * 1 SISO |

- Describe three options of the Physical layer in the IEEE802. 11 standard.

   >Three options
   >
   >- Frequency Hopping Spread Spectrum (FHSS)
   >- Direct Sequence Spread Spectrum (DSSS)
   >- Diffused Infra Red (DFIR)

#### ✅Describe in detail the ... in IEEE802.11.

- ✅handoff process

   > The handoff process in IEEE 802.11 networks can be divided into two steps: Discovery and Reauthentication.
   >
   > - Trigger: For example, the signal strength is weakened and the signal-to-noise ratio (SNR) from the current AP is reduced.
   >
   > - Discovery+AP Selection: Before closing the connection to the current AP, find potential APs that may be associated with it. This process of picking or finding is called Scanning.
   >    - The IEEE 802.11 standard defines two scanning methods: active and passive：
   >       - During the passive scanning process the mobile host listens to the channel one by one waiting for the beacon frames sent by the different APs. Using the information obtained from these beacon frames, the MH can select the next AP to be associated with.
   >       - In active scan mode, MH detects different APs by sending a Probe Request on each channel. the AP that receives the Probe Request tells its information to MH by replying to the Probe Response. based on the information of these APs, MH selects the next AP it wants to associate with.
   > - Authentication is the process by which the AP accepts or rejects the identity of the MH. The MH starts the authentication process by sending an authentication request frame informing the AP of its identity. The AP then replies with a response frame indicating its opinion (acceptance or rejection). Once the authentication is successfully completed, the MH sends a re-association request frame to the new AP, which then responds with a re-association response frame containing an acceptance or rejection notification.

- ✅power management 

   > The 802.11 standard provides power-management capabilities that allow 802.11 nodes to minimize the amount of time that their sense, transmit, and receive functions and other circuitry need to be “on.” 802.11 power management operates as follows. A node is able to explicitly alternate between sleep and wake states. A node indicates to the access point that it will be going to sleep by setting the power-management bit in the header of an 802.11 frame to 1. A timer in the node is then set to wake up the node just before the AP is scheduled to send its beacon frame. Since the AP knows from the set power-transmission bit that the node is going to sleep, the AP knows that it should not send any frames to that node, and will buffer any frames destined for the sleeping host for later transmission.
   > A node will wake up just before the AP sends a beacon frame, and quickly enter the fully active state. The beacon frames sent out by the AP contain a list of nodes whose frames have been buffered at the AP. If there are no buffered frames for the node, it can go back to sleep. Otherwise, the node can explicitly request that the buffered frames be sent by sending a polling message to the AP. A node that has no frames to send or receive can be asleep 99% of the time, resulting in a significant energy savings.

#### 🤔️Specific features in IEEE 802.11

- IEEE 802.11 **a / c**:
   - ✅Describe the main features in the IEEE802.11 a/c proposal.
   
      > The new standard achieves much higher data rates than 802.11n by means of enhancements in three areas:
      >
      > - Bandwidth: The maximum bandwidth of 802.11n is 40 MHz; the maximum bandwidth of 802.11ac is 160 MHz.
      > - Signal encoding: 802.11n can use 64 QAM with OFDM, and 802.11ac can use 256 QAM with OFDM. Thus, more bits can be encoded per symbol. Both schemes use forward error correction with a code rate of 5/6.
      > - MIMO: With 802.11n, there can be a maximum of 4 channel input and 4 channel output antennas. 802.11ac increases this to 8 * 8.
   
- IEEE 802.11 / **i**:
   - ✅Describe the improvements on security being made in IEEE802.11i.
   
      > Main areas of improvement in IEEE 802.11i are -
      >
      > - Authentication：Before the AS authenticates a supplicant using an authentication protocol, the authenticator only passes control or authentication messages between the supplicant and the AS; the 802.1X control channel is unblocked, but the 802.11 data channel is blocked. Once a supplicant is authenticated and keys are provided, the authenticator can forward data from the supplicant, subject to predefined access control limitations for the supplicant to the network. Under these circumstances, the data channel is unblocked.
      > - Key management: During the key management phase, a variety of cryptographic keys are generated and distributed to STAs. There are two types of keys: pairwise keys used for communication between an STA and an AP and group keys used for multicast communication.
      > - Data transfer : IEEE 802.11i defines two schemes for protecting data transmitted in 802.11 MPDUs: the Temporal Key Integrity Protocol (TKIP) and the Counter Mode-CBC MAC Protocol (CCMP).
   
   - 🤔️Explain how the WLAN security is improved in WPA2.
   
      > Authentication & Integrity：
      >
      > - Key management and message integrity is handled by a single component built around AES
      >
      > - Using a CBC-MAC (Cipher Block Chaining Message Authentication Code)
      >
      > Encryption
      >
      > - Uses CTR (Counter mode) AES (128 bit)
      > - Computationally expensive and adds a significant amount of overhead
      > - Use CCMP (Counter Mode with Cipher Block Chaining Message Authentication Code Protocol) instead of TKIP
   
- ✅IEEE 802.11 / **n**:
   - ✅Describe the main improvements being made in IEEE802.11n standards.
   
      > IEEE 802.11n embodies changes in three general areas: 
      >
      > - use of MIMO：MIMO stands for multiple inputs and multiple outputs, which means a device with multiple transmitters emitting signals and a device with multiple receivers receiving the signals. A MIMO system is often represented as NxM where N is the number of inputs and M is the number of outputs.
      > - enhancements in radio transmission：The most significant of these techniques, known as channel bonding, combines two 20 MHz channels to create a 40 MHz channel. Using OFDM, this allows for a little more than twice as many subchannels, more than doubling the transmission rate.The effect is that 802.11n achieves slightly more than double the rate with 40 MHz channels.
      > - MAC enhancements. The most significant change is to aggregate multiple MAC frames into a single block for transmission. With 802.11n the receiver can send a single block acknowledgment. The physical header associated with transmission is sent only at the beginning of the aggregated frame, rather than one physical header per individual frame. Frame aggregation can result in significantly improved efficient use of the transmission capacity. Each frame no longer requires its own ACK and the associated IFS times.
      >
      > The goal of this effort was to not just increase the bit rate of the transmitting antennas but to increase the effective throughput of the network. Increasing effective throughput involves looking at the signal encoding scheme, also at the antenna architecture and the MAC frame structure. IEEE 802.11 n standard is defined to operate in both the 2.4 GHz and the 5 GHz bands and can therefore be made upwardly compatible with either 802.11a or 802.11b/g.
   
   - ✅Describe the main features of three operation modes in IEEE802.11n standards.
   
      > There are three basic 802.11n operating modes
      >
      > – 802.11na
      >
      > – 802.11ng
      >
      > – Greenfield
      >
      > - When configured as 802.11na or 802.11ng, an AP will accept connections from a and g client respectively;
      > - Greenfield mode is a ‘pure’ n mode and will not accept connections from legacy clients;

---

### ⚠️Bluetooth Standard

#### Explain the network topology and access methods in Bluetooth.

#### Describe the Radio Specification of Bluetooth 2.0.

#### Low Energy Standard in BlueTooth

- Describe the main features of the Bluetooth Low Energy standard.
- With the help of a diagram, explain how data transaction is done in the Bluetooth Low Energy standard (4.0).

#### Describe the security improvement made in Bluetooth 2.1

---

### ⚠️Zigbee & WiMedia

#### Describe the network topology used in WiMedia.

#### Describe the main features of Zigbee

#### Explain the attributes of Zigbee system.

#### Explain what makes Zigbee a competing technology in the Wireless World.

---

### ⚠️Big shots

#### Considering the basic cellular operation for mobile initialisation, 

> when the mobile station is turned on by the user, briefly describe the general steps that occur from the moment the mobile station is turned on up to the stage the mobile station enters the idle state, if there is cellular service available. 
>
> (Tip: base your answer on the first generation steps that are the simplest to explain.)
>
> > 

#### Describe the concept of Soft Handoff and also describe the characteristics of the special receiver that makes soft handoff possible.

#### With the help of a diagram, describe four possible schemes in searching for a candidate cell in the handoff procedure.

#### Explain why the concept of conventional frequency reuse and planning found in FDMA and TDMA systems is not used for a CDMA system.

#### What is the carrier to interefence ratio and how can it be calculated?

#### HSUPA

- Explain the main concept of HSUPA and give an illustration of the general functionality of HSUPA.
- Describe the general functionality of HSUPA.

#### Describe the functionality of the Rake receiver in CDMA systems.

> page 269

#### UMTS

- With the help of a diagram, explain how the soft-handover works in UMTS.
- Explain the outer loop power control used in UMTS.
- Explain inner/closed (fast) power control as used in UMTS.

#### Explain the multiple access technique used in GSM systems and cite the name of the the random access method used in GSM .

#### Answer the following questions in the GSM system

- How many time slots are used in a TDMA frame?
- How many cells are adopted in a cluster? How many sectors are divided in a cell?
- What are the HLR and VLR?
- What kind of random access method is used when a Mobile Station wants to access to GSM system?
- Explain what kind of power control is used in the GSM system.

#### Describe the operation procedure in the mobile terminated call in the GSM system.

#### Answer the following questions related to Short Messaging Services (SMS) in GSM

- Explain briefly the architecture of Short Messaging Service (SMS) in GSM;
- Describe the operation of a Mobile Terminated SMS in GSM.

#### Answer the following questions about Short Messaging Services (SMS):

- Which network component is responsible for controlling the Short Messaging Services?
- Cite the two SMS types of services?
- Cite 2 different logical channels that can be used to transmit SMS messages?

#### Answer the following questions about HSDPA

- What does HSDPA stand for?
- What are the improvments deployed in HSDPA.
- Explain how the transmission latency is improved in HSDPA.
- Explain the main concept of HSDPA and give a simple illustration of the general functionality of HSDPA.
- Describe the means used by HSDPA to increase downlink data throughput.
- What radio entity is modified mainly to cope with and control HSDPA channels?
- What radio entity was modified mainly to cope with and control HSDPA channels?
- What is the improvement made on the transmission error control in HSDPA.
- Cite two important features of UMTS channels that are disabled in HSDPA channels.
- Cite one of the means used by HSDPA to increase downlink data throughput.
- State the changes made in layer 1 (L1) that make the HSDPA increase the downlink packet data throughput.
- What architectural component is responsible for the actions you answered in item i) and also for the fast link adaptation?
-  In UMTS, the transport channel carrying the user data with HSDPA operation, which is called High Speed Downlink Shared Channel (SH-DSCH), behaves differently than a Dedicated Channel (DCH) in terms of power control, variable spread coding and handoff. Explain these differences.

#### With the help of diagrams, explain how the OFDMA works in LTE downlinks.

\#todo

#### LTE-A

> 1. Explain in detail the Carrier Aggregation in the LTE-A standard.
> 2. With the help of diagrams, describe the handover procedure in the LTE-A standard.

#### UMTS/GSM network

![image-20220109225645401](https://tva1.sinaimg.cn/large/008i3skNly1gy7taxtnwgj30v20ju40r.jpg)

> Figure 1 gives an overview of several types of handover in a combined UMTS/GSM network. Indicate what handover $UE_i ( i=1, 2, 3,4)$ is performing and describe this type of handover.

#### Considering the importance of power control in cellular networks, answer the following questions.

- Explain Open Loop Power Control used in the IS-95 system.
-  Why is Power Control so important in CDMA systems?

#### Calculate the capacity of a single CDMA cell.

- Describe how the capacity of a single CDMA cell can be calculated and supply an example considering an SIR between 4dB and 10dB, a data transmission rate of 9600bps and the carrier bandwidth used in IS-95 (the channel bandwidth is 1.25MHz).

- Describe how the capacity of a single CDMA cell can be calculated and supply an example considering an SIR between 3dB and 9dB, a data transmission rate of 9600bps and the carrier bandwidth used in IS-95 (the channel bandwidth is 1.25MHz).

- Describe how the capacity of a single CDMA cell can be calculated and supply an

   example considering an SIR between 3dB and 9dB, a data transmission rate of

   9600bps and the carrier bandwith used in IS-95.

#### The GPRS network is built on the GSM network to provide data services. 

- Sketch the GPRS network architecture and name two key nodes.
- Describe the functions of two GPRS supporting nodes.
- Sketch the GPRS network architecture and describe in detail two GPRS supporting nodes.
- Sketch the GSM/GPRS reference architecture and explain the function of the GPRS entities.

---

>  **Supply the appropriate words to fill the blanks in the following sentences about the UMTS system (Note: write your answer in the answer book and NOT on this page)**：

> UMTS system uses W-CDMA as its multiple access technique. \_\_\_\_\_\_\_\_\_(1) power control is a very important aspect in UMTS, in particular in the uplink, because of the near-far problem. \_\_\_\_\_\_\_\_\_ \_\_\_\_\_\_\_\_\_ (2) power control mechanisms make a rough estimate of path loss by means of a downlink beacon signal. In \_\_\_\_\_\_\_\_\_ \_\_\_\_\_\_\_\_\_(3) power control, the BS performs frequent estimates of the received Signal-toInterference Ratio (SIR) in the \_\_\_\_\_\_\_\_\_ (4) and compares it to a target SIR. If the measured SIR is higher than the target SIR, the BS will command the MS to lower the power; if it is too low it will command the MS to increase its power. \_\_\_\_\_\_\_\_\_ \_\_\_\_\_\_\_\_\_ (5) power control adjusts the target SIR in the BS according to the needs of the individual radio link.
>
> ---
>
> UMTS uses \_\_\_\_W-CDMA_\_\_\_\_ (1) as its multiple access technique. Each frequency carrier in UMTS occupies a frequency band of 4.4 to \_\_\_\_\_\_\_\_\_ (2) MHz. \_\_\_\_\_\_\_\_\_(3) power control is a very important aspect in UMTS, in particular in the uplink, because of the \_\_\_\_\_\_\_\_\_(4) problem. \_\_\_\_\_\_\_\_\_ (5) power control mechanisms make a rough estimate of path loss by means of a downlink beacon signal. In \_\_\_\_\_\_\_\_\_ \_\_\_\_\_\_\_\_\_(6) power control, the BS performs frequent estimates of the received Signal-to-Interference Ratio (SIR) in the \_\_\_\_\_\_\_\_\_ (7) and compares it to a target SIR. If the measured SIR is higher than the target SIR, the BS will command the MS to \_\_\_\_\_\_\_\_\_ (8) the power; if it is too low it will command the MS to \_\_\_\_\_\_\_\_\_ (9) its power. \_\_\_\_\_\_\_\_\_ \_\_\_\_\_\_\_\_\_ (10) power control adjusts the target SIR in the BS according to the needs of the individual radio link.
>
> ---
>
> GSM uses \_\_\_\_\_\_\_\_\_(1) as a multiple access technique. The GSM spectrum provides \_\_\_\_\_\_\_\_\_(2) different frequency carriers, and a guard band is left between the first and the last carrier. Each frequency carrier in GSM occupies a frequency band of \_\_\_\_\_\_\_\_\_(3) accommodating \_\_\_\_\_\_\_\_\_(4) logical channels in it. Each logical channel is defined by the repetitive occurrence of  \_\_\_\_\_\_\_\_\_(5) each one with an approximate duration of 0.577ms. In a GSM full rate traffic channel, the payload data is encrypted in blocks of \_\_\_\_\_\_\_\_\_(6) bits. The capacity in kbps of a full rate traffic channel is \_\_\_\_\_\_\_\_\_(7), this value takes into consideration that in \_\_\_\_\_\_\_\_\_(8) frames occurring in a \_\_\_\_\_\_\_\_\_(9) ms multi-frame, \_\_\_\_\_\_\_\_\_(10) slots are used for other purposes which are: \_\_\_\_\_\_\_\_\_(11) and the \_\_\_\_\_\_\_\_\_(12) logical channel.
>
> ---
>
> Security in GSM is implemented to prevent fraud via \_\_\_\_\_\_\_\_\_ (1) of the subscriber, not revealing the subscriber number over the air, and by \_\_\_\_\_\_\_\_\_ (2) the conversations to avoid eavesdropping. The SIM card has a microprocessor chip that can perform the computations required for security purposes. A \_\_\_\_\_\_\_\_\_ (3) key Ki is stored on the SIM card, and it is unique to the card. This key is used in two proprietary algorithms: A3 for \_\_\_\_\_\_\_\_\_ (4) and A8 for \_\_\_\_\_\_\_\_\_ (5). Ki is used in a \_\_\_\_\_\_\_\_\_ (6) response protocol using the A3 algorithm between the BSS/MSC and the MS. Ki is used to generate a privacy key \_\_\_\_\_\_\_\_\_ (7) that is used to \_\_\_\_\_\_\_\_\_ (8) messages (voice or data) using the A8 algorithm. Finally, the control channel signals are also \_\_\_\_\_\_\_\_\_ (9) to avoid eavesdropping by using a third algorithm called \_\_\_\_\_\_\_\_\_ (10).
>
> ---
>
> The technologies applied with HSUPA improve the \_\_\_\_\_\_\_\_\_ (1) packet data performance by means of fast physical layer (L1) \_\_\_\_\_\_\_\_\_(2) and transmission \_\_\_\_\_\_\_\_\_ (3), as well as fast Node B \_\_\_\_\_\_\_\_\_(4). HSUPA general functionality: The \_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_ (5) estimates the data rate transmission needs of each active HSUPA user based on the device-specific \_\_\_\_\_\_\_\_\_(6); The scheduler in the \_\_\_\_\_\_\_\_\_(7) then provides instruction to devices on the \_\_\_\_\_\_\_\_\_ (8) link data rate to be used at a fast pace depending on the \_\_\_\_\_\_\_\_\_ (9) received before, the scheduling algorithm and the \_\_\_\_\_\_\_\_\_ (10) prioritisation scheme.
>
> ---
>
> - In traffic engineering, assume a cell receives on average 630 calls per hour, the mean holding time is 120 seconds, and the grade of service is 2%. Therefore, the offered traffic in the cell is \_\_\_\_\_\_\_\_\_ (1) and the dimensionless unit is \_\_\_\_\_\_\_\_\_(2). If the number of channels needed for this offered traffic is 28 channels, the corresponding trunking efficiency is \_\_\_\_\_\_\_\_\_ (3).
>- In a FDMA/TDMA system, there are two types of frequency interference. The first type is the cochannel interference and the second type is the \_\_\_\_\_\_\_\_\_ (1) channel interference. Depending of the value of the cochannel reuse ratio the network will have different number of cells per cluster. For example, if the cochannel reuse ratio is 6, the number of cells per cluster will be \_\_\_\_\_\_\_\_\_ (2). In order to avoid the second type of frequency interference, the assigned frequencies for the channels of a cell have maximum possible \_\_\_\_\_\_\_\_\_ (3) and sectorization can also help.

