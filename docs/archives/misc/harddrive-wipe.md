# Your Guide to Nuking a Computer's Hard Drive

---

***Note:*** Please remember to only wipe the PC if it has been a month since we received it back!

### To Wipe:

1. Go to [DBAN - SourceForge](https://sourceforge.net/projects/dban/files/dban/dban-2.2.8/) and download Derik's Boot and Nuke Live ISO.
	- Please be aware that you need the `2.2.8` version!!! Make sure you are downloading the `2.2.8` version!!!
2. Go to [Rufus](https://rufus.ie/en/#) and download the latest version they have.
	- Rufus is a open-sourced software used for creating Bootable USBs.
3. Next, grab a USB and connect it to the computer you used to install rufus. (Use at least USB 3.0 unless you want to regret life)
4. Run the Rufus installation.
5. Select the correct USB from the **Devices** list.
6. Click the select button and select the DBAN Live ISO that you downloaded earlier.
7. Next, click **Start** and allow Rufus to finish reformatting the Flash drive.
8. ***Safely*** eject the drive from the computer (unless you are doing this entire process on the computer you are trying to nuke. If this applies to you, skip this step and the next step.)
9. Plug in the flash drive to the computer you wish to nuke.
10. Turn the computer off and on again.
	- When turning it on, please spam click the BIOS button. (This differs by the device. Typically for Dell it is usually `F2` or `F12`, but I like to spam `F2`, `F3`, `F4` and the `Enter` button all at once.)
11. Once you have entered the BIOS menus.
	a) Navigate to the Secure Boot Menu and Disable Secure Boot.
	b) Navigate to Advanced Boot Options and Check **Enable Legacy Option ROMS**
	c) Navigate to Boot Sequence and change the Boot List Option to **Legacy** from **UEFI**.
	d) Next, move the **USB Devices** Boot option to the top of the list of options under Boot Sequence.
	e) Click Apply at the bottom and Exit.
12. The computer should restart and show you the DBAN boot screen.
13. Type in `autonuke`.
14. Wait and pray there's no errors.
15. Profit.

